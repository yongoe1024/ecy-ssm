package com.yongoe.ecy.project.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongoe.ecy.project.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 投稿管理
 *
 * @author yongoe
 * @since 2024/02/22
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

    Page<Article> getArticleByPage(Page<Article> page, @Param("article") Article article);

}
