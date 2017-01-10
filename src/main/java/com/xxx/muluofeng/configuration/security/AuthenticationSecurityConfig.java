package com.xxx.muluofeng.configuration.security;

import com.xxx.muluofeng.service.AdminDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;

/**
 * Created by Administrator on 2017/1/10.
 */
@Configuration
//@Order(Ordered.HIGHEST_PRECEDENCE + 10)
public class AuthenticationSecurityConfig extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    AdminDetailsService adminDetailsService;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
        auth.userDetailsService(adminDetailsService).passwordEncoder(passwordEncoder);
    }
}
