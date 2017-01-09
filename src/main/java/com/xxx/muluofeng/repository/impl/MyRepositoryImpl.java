package com.xxx.muluofeng.repository.impl;

import com.xxx.muluofeng.repository.MyRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/1/6.
 */
public class MyRepositoryImpl<T,ID extends Serializable> extends SimpleJpaRepository<T,ID> implements MyRepository<T,ID>{
    public MyRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    public MyRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
    }

    @Override
    public void sharedCustomMethod(ID id) {
        System.out.println("自定义的sharedCustomMethod");
    }
}
