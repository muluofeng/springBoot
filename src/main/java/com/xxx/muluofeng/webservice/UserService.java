package com.xxx.muluofeng.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 * Created by Administrator on 2016/12/21.
 */
//@WebService
public interface UserService {
    @WebMethod
    String getName(@WebParam(name = "userId") Long userId);
    @WebMethod
    User getUser(Long userId);
}