package com.xxx.muluofeng.repository.impl;

import com.xxx.muluofeng.entities.User;
import com.xxx.muluofeng.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Administrator on 2016/12/30.
 */

@Repository("userDaoImpl")
public class UserRepositoryImpl  extends JdbcDaoSupport implements UserRepository {

    @Autowired
    private DataSource dataSource;

    @Override
    public List<User> userQuery() {
        return null;
    }

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }
}
