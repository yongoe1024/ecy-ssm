package com.yongoe.ecy.project.service;

import com.yongoe.ecy.project.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 投稿管理
 *
 * @author yongoe
 * @since 2024/02/22
 */
public interface ArticleService extends IService<Article> {

    Page<Article> getArticleByPage(Page<Article> page, Article article);

}
