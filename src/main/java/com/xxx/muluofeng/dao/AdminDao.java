package com.xxx.muluofeng.dao;

import com.xxx.muluofeng.entities.Admin;
import com.xxx.muluofeng.repository.MyRepository;

/**
 * Created by Administrator on 2017/1/10.
 */

public interface AdminDao extends MyRepository<Admin,Integer> {
    public Admin findByLoginName(String loginName);
}
