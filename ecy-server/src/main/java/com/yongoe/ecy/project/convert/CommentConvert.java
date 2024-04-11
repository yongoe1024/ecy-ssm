package com.yongoe.ecy.project.convert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongoe.ecy.project.controller.vo.excel.CommentExcel;
import com.yongoe.ecy.project.controller.vo.req.CommentReq;
import com.yongoe.ecy.project.controller.vo.res.CommentRes;
import com.yongoe.ecy.project.entity.Comment;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * 留言评论 convert
 *
 * @author yongoe
 * @since 2024/04/11
 */
@Mapper(componentModel = "spring")
public interface CommentConvert {
    /**
     * entity to vo
     */
    CommentReq entity2Req(Comment entity);

    CommentRes entity2Res(Comment entity);

    CommentExcel entity2Excel(Comment entity);

    /**
     * entity to vo List
     */
    List<CommentReq> entity2ReqList(List<Comment> list);

    List<CommentRes> entity2ResList(List<Comment> list);

    List<CommentExcel> entity2ExcelList(List<Comment> list);

    /**
     * entity to vo Page
     */
    Page<CommentRes> entity2ResPage(Page<Comment> page);

    /**
     * vo to entity
     */
    Comment req2Entity(CommentReq req);

    Comment excel2Entity(CommentExcel excel);

    /**
     * vo to entity List
     */
    List<Comment> excel2EntityList(List<CommentExcel> list);


}