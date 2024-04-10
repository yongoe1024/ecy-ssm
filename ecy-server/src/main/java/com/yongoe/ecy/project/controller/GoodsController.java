package com.yongoe.ecy.project.controller;

import com.yongoe.ecy.project.entity.Prize;
import com.yongoe.ecy.project.entity.PrizeRecord;
import com.yongoe.ecy.project.service.GoodsService;
import com.yongoe.ecy.config.aop.WebLog;
import com.yongoe.ecy.project.controller.vo.excel.GoodsExcel;
import com.yongoe.ecy.project.controller.vo.req.GoodsReq;
import com.yongoe.ecy.project.controller.vo.res.GoodsRes;
import com.yongoe.ecy.project.convert.GoodsConvert;
import com.yongoe.ecy.project.entity.Goods;
import com.yongoe.ecy.project.service.JiluService;
import com.yongoe.ecy.system.service.UserService;
import com.yongoe.ecy.utils.ExcelUtils;
import com.yongoe.ecy.utils.PageUtils;
import com.yongoe.ecy.utils.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongoe.ecy.utils.UserUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 垃圾回收
 *
 * @author yongoe
 * @since 2024/02/22
 */
@RestController
@RequestMapping("/project/goods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;
    @Resource
    private GoodsConvert goodsConvert;
    @Resource
    private UserService userService;
    @Resource
    private JiluService jiluService;

    @PostMapping("/public/page")
    public R publicpage(@RequestBody GoodsReq req) {
        Goods entity = goodsConvert.req2Entity(req);
        Page<Goods> page = goodsService.getGoodsByPage(Page.of(req.getCurrent(), req.getSize()), entity);
        Page<GoodsRes> resPage = goodsConvert.entity2ResPage(page);
        return R.success().put(new PageUtils(resPage));
    }

    @PostMapping("/info")
    public R info(@RequestBody GoodsReq req) {
        String name = UserUtils.getName();
        Goods goods = goodsService.getById(req.getId());
        if (name.equals(goods.getCreateBy()) || name.equals(goods.getBuyer())) {
            return R.success().put(goods);
        }else{
            return R.error("无权限查看");
        }
    }

    @PostMapping("/buy/{id}")
    public R page(@PathVariable Long id) {
        String phone = UserUtils.getUser().getPhone();
        if (phone == null || phone.equals("")) {
            return R.error("请完善个人信息后再购买");
        }
        if(UserUtils.getName().equals(goodsService.getById(id).getCreateBy())){
            return R.error("不能购买自己发布的商品");
        }
        Goods goods = goodsService.getById(id);
        goods.setBuyer(UserUtils.getName());
        goods.setBuyerPhone(UserUtils.getUser().getPhone());
        goods.setBuyTime(LocalDateTime.now());
        goods.setStatus("交易中");
        goodsService.updateById(goods);
        return R.success("购买成功，请前往个人中心查看交易详情！");
    }

    @PostMapping("/finish/{id}")
    public R finish(@PathVariable Long id) {
        Goods goods = goodsService.getById(id);
        goods.setStatus("已售出");
        jiluService.updateScore(goods.getBuyer(),1,"垃圾回收-购买商品");
        jiluService.updateScore(goods.getCreateBy(),1,"垃圾回收-出售商品");
        goodsService.updateById(goods);
        return R.success("成功");
    }

    @PostMapping("/fail/{id}")
    public R fail(@PathVariable Long id) {
        Goods goods = goodsService.getById(id);
        goods.setBuyer("");
        goods.setBuyerPhone("");
        goods.setStatus("未售出");
        goodsService.updateById(goods);
        return R.success("成功");
    }

    //@WebLog(description = "垃圾回收-查询数据")
    @PostMapping("/page")
    public R page(@RequestBody GoodsReq req) {
        Goods entity = goodsConvert.req2Entity(req);
        Page<Goods> page = goodsService.getGoodsByPage(Page.of(req.getCurrent(), req.getSize()), entity);
        Page<GoodsRes> resPage = goodsConvert.entity2ResPage(page);
        return R.success().put(new PageUtils(resPage));
    }

    @WebLog(description = "垃圾回收-添加数据")
    @PostMapping("/add")
    public R add(@RequestBody GoodsReq req) {
        Goods goods = goodsConvert.req2Entity(req);
        goodsService.save(goods);
        return R.success("添加成功");
    }

    @WebLog(description = "垃圾回收-修改数据")
    @PostMapping("/update")
    public R update(@RequestBody GoodsReq req) {
        Goods goods = goodsConvert.req2Entity(req);
        goodsService.updateById(goods);
        return R.success("修改成功");
    }

    @WebLog(description = "垃圾回收-删除数据")
    @PostMapping("/delete/{ids}")
    public R delete(@PathVariable List<Long> ids) {
        goodsService.removeByIds(ids);
        return R.success("删除成功");
    }

    @WebLog(description = "垃圾回收-导入数据")
    @PostMapping("/upload")
    public R upload(MultipartFile file) {
        List<GoodsExcel> excelList = ExcelUtils.upload(file, GoodsExcel.class);
        List<Goods> list = goodsConvert.excel2EntityList(excelList);
        goodsService.saveBatch(list);
        return R.success("导入成功");
    }

    @WebLog(description = "垃圾回收-导出数据")
    @GetMapping("/export")
    public void export(GoodsReq req, HttpServletResponse response) {
        Goods entity = goodsConvert.req2Entity(req);
        Page<Goods> page = goodsService.getGoodsByPage(Page.of(-1, -1), entity);
        List<GoodsExcel> list = goodsConvert.entity2ExcelList(page.getRecords());
        ExcelUtils.export(response, list, GoodsExcel.class);
    }
}