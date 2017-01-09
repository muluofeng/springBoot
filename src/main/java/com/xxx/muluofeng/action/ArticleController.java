package com.xxx.muluofeng.action;

import com.xxx.muluofeng.entities.Article;
import com.xxx.muluofeng.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/30.
 */
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    @RequestMapping(value = "articles")
    public String getArticles(){
        return "articlelist";
    }

    /**
     *
     * @param draw    这个是用来确保Ajax从服务器返回的是对应的（Ajax是异步的，因此返回的顺序是不确定的）。 要求在服务器接收到此参数后再返回
     * @param start   第一条数据的起始位置，比如0代表第一条数据
     * @param length  告诉服务器每页显示的条数
     * @param search  全局的搜索条件
     * @return
     */
    @RequestMapping(value = "/articleList")
    @ResponseBody
    public Map<String, Object> getArticleList(int draw, int start, int length,
                                 @RequestParam("search[value]") String search){
        Map<String, Object> map = new HashMap<String,Object>();

        if(start!=0){
            start=start/length;
        }
        Sort sort=new Sort(Sort.Direction.DESC,"articleId");    //排序
        Pageable pageable=new PageRequest(start,length,sort);              //分页
        Page<Article> articlePage=articleService.findAll(pageable);
//        System.out.print(articlePage.getContent().get(0).getUser().getName());
        map.put("draw", draw);
        map.put("recordsTotal", articlePage.getTotalPages()); //数据库里总共记录数
        map.put("recordsFiltered",articlePage.getTotalElements());//返回的是过滤后的记录数
        map.put("data", articlePage.getContent());
        return map;
    }


    @RequestMapping("getArticle")
    @ResponseBody
    public Map<String,Object> getArticle(
            @RequestParam(value = "title" ,required = false)String title,
            @RequestParam(value = "name" ,required = false)String name
    ){
        Map<String, Object> map = new HashMap<String,Object>();
//        List<Article> article=articleService.findByTitle(title);
        List<Article> article=articleService.findByUsername(name);
        map.put("article",article);
        return map;
    }

}
