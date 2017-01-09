package com.xxx.muluofeng.webservice;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/12/21.
 */
public class User implements Serializable {
    private static final long serialVersionUID = -5939599230753662529L;
    private Long              userId;
    private String            username;
    private String            email;
    private Date gmtCreate;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User-ID"+userId+"User-Name"+username;
    }
}