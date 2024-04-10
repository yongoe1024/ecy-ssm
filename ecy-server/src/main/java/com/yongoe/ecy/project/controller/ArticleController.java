package com.yongoe.ecy.project.controller;

import com.yongoe.ecy.project.entity.Rubbish;
import com.yongoe.ecy.project.service.ArticleService;
import com.yongoe.ecy.config.aop.WebLog;
import com.yongoe.ecy.project.controller.vo.excel.ArticleExcel;
import com.yongoe.ecy.project.controller.vo.req.ArticleReq;
import com.yongoe.ecy.project.controller.vo.res.ArticleRes;
import com.yongoe.ecy.project.convert.ArticleConvert;
import com.yongoe.ecy.project.entity.Article;
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
import java.util.List;

/**
 * 投稿管理
 *
 * @author yongoe
 * @since 2024/02/22
 */
@RestController
@RequestMapping("/project/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;
    @Resource
    private ArticleConvert articleConvert;
    @Resource
    private UserService userService;
    @Resource
    JiluService jiluService;

    @PostMapping("/public/page")
    public R publicpage(@RequestBody ArticleReq req) {
        Article entity = articleConvert.req2Entity(req);
        Page<Article> page = articleService.getArticleByPage(Page.of(req.getCurrent(), req.getSize()), entity);
        Page<ArticleRes> resPage = articleConvert.entity2ResPage(page);
        return R.success().put(new PageUtils(resPage));
    }

    @PostMapping("/yes/{id}/{value}")
    public R yes(@PathVariable Long id,@PathVariable Integer value){
        Article article = articleService.getById(id);
        article.setStatus("通过");
        article.setScore(value);
        jiluService.updateScore(article.getCreateBy(),value,"投稿");
        articleService.updateById(article);
        return R.success("操作成功");
    }

    @PostMapping("/no/{id}")
    public R no(@PathVariable Long id){
        Article article = articleService.getById(id);
        article.setStatus("拒绝");
        articleService.updateById(article);
        return R.success("操作成功");
    }


    //@WebLog(description = "投稿管理-查询数据")
    @PostMapping("/page")
    public R page(@RequestBody ArticleReq req) {
        Article entity = articleConvert.req2Entity(req);
        if(UserUtils.isRole("register")) {
            entity.setCreateBy(UserUtils.getName());
        }
        Page<Article> page = articleService.getArticleByPage(Page.of(req.getCurrent(), req.getSize()), entity);
        Page<ArticleRes> resPage = articleConvert.entity2ResPage(page);
        return R.success().put(new PageUtils(resPage));
    }

    @WebLog(description = "投稿管理-添加数据")
    @PostMapping("/add")
    public R add(@RequestBody ArticleReq req) {
        Article article = articleConvert.req2Entity(req);
        articleService.save(article);
        return R.success("添加成功");
    }

    @WebLog(description = "投稿管理-修改数据")
    @PostMapping("/update")
    public R update(@RequestBody ArticleReq req) {
        Article article = articleConvert.req2Entity(req);
        articleService.updateById(article);
        return R.success("修改成功");
    }

    @WebLog(description = "投稿管理-删除数据")
    @PostMapping("/delete/{ids}")
    public R delete(@PathVariable List<Long> ids) {
        articleService.removeByIds(ids);
        return R.success("删除成功");
    }

    @WebLog(description = "投稿管理-导入数据")
    @PostMapping("/upload")
    public R upload(MultipartFile file) {
        List<ArticleExcel> excelList = ExcelUtils.upload(file, ArticleExcel.class);
        List<Article> list = articleConvert.excel2EntityList(excelList);
        articleService.saveBatch(list);
        return R.success("导入成功");
    }

    @WebLog(description = "投稿管理-导出数据")
    @GetMapping("/export")
    public void export(ArticleReq req, HttpServletResponse response) {
        Article entity = articleConvert.req2Entity(req);
        Page<Article> page = articleService.getArticleByPage(Page.of(-1, -1), entity);
        List<ArticleExcel> list = articleConvert.entity2ExcelList(page.getRecords());
        ExcelUtils.export(response, list, ArticleExcel.class);
    }
}