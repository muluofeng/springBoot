package com.xxx.muluofeng.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Administrator on 2017/1/9.
 */
@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                // 路径权限
                .authorizeRequests()
                .antMatchers("/admin/login").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and()
                // 登录
                .formLogin()
                .loginPage("/admin/login").failureUrl("/admin/login?error")
                .loginProcessingUrl("/admin/dologin")
                .defaultSuccessUrl("/admin/articles")
                .usernameParameter("username").passwordParameter("password")
                .permitAll()
                .and()
                // 退出
                .logout()
                .logoutUrl("/admin/logout")
                .logoutSuccessUrl("/admin/login")
                .permitAll()
                .and();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //WebSecurity一般用户忽略文件夹
        web.ignoring().antMatchers("/assets/**", "/js/**", "/css/**", "/images/**");
    }

    @Autowired
    public void configureGlobal( AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
}
