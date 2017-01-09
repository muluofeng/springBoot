package com.xxx.muluofeng.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/1/6.
 */
@NoRepositoryBean
public interface MyRepository<T,ID extends Serializable>  extends PagingAndSortingRepository<T,ID>{
    void sharedCustomMethod(ID id);
}
