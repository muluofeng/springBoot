package com.xxx.muluofeng.dao;

import com.xxx.muluofeng.entities.Article;
import com.xxx.muluofeng.repository.MyRepository;
import com.xxx.muluofeng.repository.impl.MyRepositoryImpl;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Administrator on 2016/12/30.
 */
public interface ArticleDao extends MyRepository<Article,Integer> {

    public Article findByTitle(String title);

    /**
     *测试一下@Query查询
     * @param title
     * @return
     */
    @Query("SeLECT a FROM Article a WHERE a.title LIKE   CONCAT('%',?1,'%')   ")
    public List<Article> getArticle(String title);

    /**
     *对一个对象的属性的子属性做查询
     * @param name
     * @return
     */
    public List<Article> findByUserName(String name);
}
