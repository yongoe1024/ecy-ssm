package com.yongoe.ecy.project.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yongoe.ecy.config.aop.IgnoreLogin;
import com.yongoe.ecy.project.service.CommentService;
import com.yongoe.ecy.config.aop.WebLog;
import com.yongoe.ecy.project.controller.vo.excel.CommentExcel;
import com.yongoe.ecy.project.controller.vo.req.CommentReq;
import com.yongoe.ecy.project.controller.vo.res.CommentRes;
import com.yongoe.ecy.project.convert.CommentConvert;
import com.yongoe.ecy.project.entity.Comment;
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
 * 留言评论
 *
 * @author yongoe
 * @since 2024/04/11
 */
@RestController
@RequestMapping("/project/comment")
public class CommentController {
    @Resource
    private CommentService commentService;
    @Resource
    private CommentConvert commentConvert;

    //@WebLog(description = "留言评论-查询数据")
    @IgnoreLogin
    @PostMapping("/page")
    public R page(@RequestBody CommentReq req) {
        Comment entity = commentConvert.req2Entity(req);
        Page<Comment> page = commentService.getCommentByPage(Page.of(req.getCurrent(), req.getSize()), entity);
        for (Comment record : page.getRecords()) {
            Long id = record.getId();
            List<Comment> children = commentService.list(new LambdaQueryWrapper<Comment>().eq(Comment::getParentId, id));
            record.setChildren(children);
        }
        Page<CommentRes> resPage = commentConvert.entity2ResPage(page);
        return R.success().put(new PageUtils(resPage));
    }

    @WebLog(description = "留言评论-添加数据")
    @PostMapping("/add")
    public R add(@RequestBody CommentReq req) {
        Comment comment = commentConvert.req2Entity(req);
        commentService.save(comment);
        return R.success("添加成功");
    }

    @WebLog(description = "留言评论-修改数据")
    @PostMapping("/update")
    public R update(@RequestBody CommentReq req) {
        Comment comment = commentConvert.req2Entity(req);
        commentService.updateById(comment);
        return R.success("修改成功");
    }

    @WebLog(description = "留言评论-删除数据")
    @PostMapping("/delete/{ids}")
    public R delete(@PathVariable List<Long> ids) {
        commentService.removeByIds(ids);
        return R.success("删除成功");
    }

    @WebLog(description = "留言评论-导入数据")
    @PostMapping("/upload")
    public R upload(MultipartFile file) {
        List<CommentExcel> excelList = ExcelUtils.upload(file, CommentExcel.class);
        List<Comment> list = commentConvert.excel2EntityList(excelList);
        commentService.saveBatch(list);
        return R.success("导入成功");
    }

    @WebLog(description = "留言评论-导出数据")
    @GetMapping("/export")
    public void export(CommentReq req, HttpServletResponse response) {
        Comment entity = commentConvert.req2Entity(req);
        Page<Comment> page = commentService.getCommentByPage(Page.of(-1, -1), entity);
        List<CommentExcel> list = commentConvert.entity2ExcelList(page.getRecords());
        ExcelUtils.export(response, list, CommentExcel.class);
    }
}