package com.xxx.muluofeng;

/**
 * Created by Administrator on 2016/12/26.
 */
public class Person {
    private String name;
    private  QksdObj qksdObj;

    public Person(String name, QksdObj qksdObj) {
        this.name = name;
        this.qksdObj = qksdObj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public QksdObj getQksdObj() {
        return qksdObj;
    }

    public void setQksdObj(QksdObj qksdObj) {
        this.qksdObj = qksdObj;
    }
}
