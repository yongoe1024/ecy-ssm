package com.yongoe.ecy.project.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongoe.ecy.project.entity.Article;
import com.yongoe.ecy.project.mapper.ArticleMapper;
import com.yongoe.ecy.project.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 投稿管理
 *
 * @author yongoe
 * @since 2024/02/22
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Override
    public Page<Article> getArticleByPage(Page<Article> page, Article article) {
       return baseMapper.getArticleByPage(page, article);
    }

}
