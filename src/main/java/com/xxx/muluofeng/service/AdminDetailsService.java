package com.xxx.muluofeng.service;

import com.xxx.muluofeng.entities.Admin;
import com.xxx.muluofeng.entities.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/1/10.
 */
@Service
public class AdminDetailsService implements UserDetailsService {


    @Autowired
    AdminService adminService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Admin admin=adminService.findByName(name);
        if(admin==null){
            System.out.println("没有发现该用户");
        }
        Set<GrantedAuthority> dbAuthsSet = new HashSet<GrantedAuthority>();
        dbAuthsSet.addAll(loadUserAuthorities());
        List<GrantedAuthority> dbAuths =new ArrayList<GrantedAuthority>(dbAuthsSet);
        return createUserDetails(name,admin,dbAuths);

    }

    private AdminUser  createUserDetails(String username, Admin admin, List<GrantedAuthority> authorities){
        AdminUser adminUser=new AdminUser(username, admin.getLoginPassword(), true, true, true, true, authorities);
        adminUser.setAdmin(admin);
        return adminUser;
    }

    protected List<GrantedAuthority> loadUserAuthorities() {
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
        List<GrantedAuthority> authorities =new ArrayList<GrantedAuthority>();
        authorities.add(authority);//如果角色多个可以添加多个

        return authorities;
    }
}
