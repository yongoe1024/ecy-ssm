package com.yongoe.ecy.project.convert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongoe.ecy.project.controller.vo.excel.ArticleExcel;
import com.yongoe.ecy.project.controller.vo.req.ArticleReq;
import com.yongoe.ecy.project.controller.vo.res.ArticleRes;
import com.yongoe.ecy.project.entity.Article;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * 投稿管理 convert
 *
 * @author yongoe
 * @since 2024/02/22
 */
@Mapper(componentModel = "spring")
public interface ArticleConvert {
    /**
     * entity to vo
     */
    ArticleReq entity2Req(Article entity);

    ArticleRes entity2Res(Article entity);

    ArticleExcel entity2Excel(Article entity);

    /**
     * entity to vo List
     */
    List<ArticleReq> entity2ReqList(List<Article> list);

    List<ArticleRes> entity2ResList(List<Article> list);

    List<ArticleExcel> entity2ExcelList(List<Article> list);

    /**
     * entity to vo Page
     */
    Page<ArticleRes> entity2ResPage(Page<Article> page);

    /**
     * vo to entity
     */
    Article req2Entity(ArticleReq req);

    Article excel2Entity(ArticleExcel excel);

    /**
     * vo to entity List
     */
    List<Article> excel2EntityList(List<ArticleExcel> list);


}