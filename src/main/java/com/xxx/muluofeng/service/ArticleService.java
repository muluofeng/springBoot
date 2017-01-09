package com.xxx.muluofeng.service;

import com.xxx.muluofeng.dao.ArticleDao;
import com.xxx.muluofeng.entities.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/12/30.
 */
@Service
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;

    public List<Article> findByTitle(String title) {
        return articleDao.getArticle(title);
    }

    public Page<Article> findAll(Pageable pageable) {
        articleDao.sharedCustomMethod(123);
        return articleDao.findAll(pageable);
    }

    public List<Article> findByUsername(String name) {
        return articleDao.findByUserName(name);
    }
}
