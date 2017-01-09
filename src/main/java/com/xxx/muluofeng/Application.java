package com.xxx.muluofeng;

import com.xxx.muluofeng.repository.impl.MyRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Administrator on 2016/12/13.
 * 说明：springboot入口类
 */
@SpringBootApplication
@ComponentScan({"com.xxx.muluofeng"})
@EntityScan("com.xxx.muluofeng.entities")
@EnableJpaRepositories(value = {"com.xxx.muluofeng.dao"},repositoryBaseClass = MyRepositoryImpl.class )
public class Application extends SpringBootServletInitializer {

    public  static  void main(String[] args){
        SpringApplication.run(Application.class,args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
}
