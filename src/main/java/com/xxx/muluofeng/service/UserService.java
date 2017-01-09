package com.xxx.muluofeng.service;

import com.xxx.muluofeng.dao.UserDao;
import com.xxx.muluofeng.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/12/29.
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }

    public void deleteById(Integer id){
         userDao.delete(id);
    }
}
