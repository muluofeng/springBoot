package com.xxx.muluofeng.service;

import com.xxx.muluofeng.dao.AdminDao;
import com.xxx.muluofeng.entities.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/1/10.
 */
@Service
public class AdminService {
    @Autowired
    AdminDao  adminDao;

    public Admin findByName(String loginName){
        return adminDao.findByLoginName(loginName);
    }

}
