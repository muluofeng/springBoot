package com.xxx.muluofeng.dao;

import com.xxx.muluofeng.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Administrator on 2016/12/28.
 */
public interface  UserDao extends JpaRepository<User, Integer>,JpaSpecificationExecutor<User>{
}
