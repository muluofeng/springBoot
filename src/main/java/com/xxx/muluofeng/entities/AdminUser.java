package com.xxx.muluofeng.entities;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by Administrator on 2017/1/10.
 */
public class AdminUser  extends org.springframework.security.core.userdetails.User{
    private Admin admin;

    public AdminUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public AdminUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
