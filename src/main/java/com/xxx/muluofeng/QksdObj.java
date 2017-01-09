package com.xxx.muluofeng;

import java.util.Date;

/**
 * Created by Administrator on 2016/12/26.
 */
public class QksdObj {
    private  int qksdID;
    private  String password;
    private Date date;

    public QksdObj(int qksdID, String password,Date date) {
        this.qksdID = qksdID;
        this.password = password;
        this.date=date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getQksdID() {
        return qksdID;
    }

    public void setQksdID(int qksdID) {
        this.qksdID = qksdID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
