package com.xxx.muluofeng.repository;

import com.xxx.muluofeng.entities.User;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/30.
 * @NoRepositoryBean这样Spring Data Jpa在启动时就不会去实例化UserRepository这个接口
 */
@NoRepositoryBean
public interface UserRepository {

        List<User> userQuery();
}
