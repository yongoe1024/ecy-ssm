package com.yongoe.ecy.project.controller;

import com.yongoe.ecy.project.service.MessageService;
import com.yongoe.ecy.config.aop.WebLog;
import com.yongoe.ecy.project.controller.vo.excel.MessageExcel;
import com.yongoe.ecy.project.controller.vo.req.MessageReq;
import com.yongoe.ecy.project.controller.vo.res.MessageRes;
import com.yongoe.ecy.project.convert.MessageConvert;
import com.yongoe.ecy.project.entity.Message;
import com.yongoe.ecy.utils.ExcelUtils;
import com.yongoe.ecy.utils.PageUtils;
import com.yongoe.ecy.utils.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.annotation.Resource;
import java.util.List;

/**
 * 留言管理
 *
 * @author yongoe
 * @since 2024/02/22
 */
@RestController
@RequestMapping("/project/message")
public class MessageController {
    @Resource
    private MessageService messageService;
    @Resource
    private MessageConvert messageConvert;

    @PostMapping("/public/page")
    public R publicpage(@RequestBody MessageReq req) {
        Message entity = messageConvert.req2Entity(req);
        entity.setParentId(0L);
        Page<Message> page = messageService.getMessageByPage(Page.of(req.getCurrent(), req.getSize()), entity);
        Page<MessageRes> resPage = messageConvert.entity2ResPage(page);
        return R.success().put(new PageUtils(resPage));
    }

    //@WebLog(description = "留言管理-查询数据")
    @PostMapping("/page")
    public R page(@RequestBody MessageReq req) {
        Message entity = messageConvert.req2Entity(req);
        Page<Message> page = messageService.getMessageByPage(Page.of(req.getCurrent(), req.getSize()), entity);
        Page<MessageRes> resPage = messageConvert.entity2ResPage(page);
        return R.success().put(new PageUtils(resPage));
    }

    @WebLog(description = "留言管理-添加数据")
    @PostMapping("/add")
    public R add(@RequestBody MessageReq req) {
        Message message = messageConvert.req2Entity(req);
        messageService.save(message);
        return R.success("添加成功");
    }

    @WebLog(description = "留言管理-修改数据")
    @PostMapping("/update")
    public R update(@RequestBody MessageReq req) {
        Message message = messageConvert.req2Entity(req);
        messageService.updateById(message);
        return R.success("修改成功");
    }

    @WebLog(description = "留言管理-删除数据")
    @PostMapping("/delete/{ids}")
    public R delete(@PathVariable List<Long> ids) {
        messageService.removeByIds(ids);
        return R.success("删除成功");
    }

    @WebLog(description = "留言管理-导入数据")
    @PostMapping("/upload")
    public R upload(MultipartFile file) {
        List<MessageExcel> excelList = ExcelUtils.upload(file, MessageExcel.class);
        List<Message> list = messageConvert.excel2EntityList(excelList);
        messageService.saveBatch(list);
        return R.success("导入成功");
    }

    @WebLog(description = "留言管理-导出数据")
    @GetMapping("/export")
    public void export(MessageReq req, HttpServletResponse response) {
        Message entity = messageConvert.req2Entity(req);
        Page<Message> page = messageService.getMessageByPage(Page.of(-1, -1), entity);
        List<MessageExcel> list = messageConvert.entity2ExcelList(page.getRecords());
        ExcelUtils.export(response, list, MessageExcel.class);
    }
}