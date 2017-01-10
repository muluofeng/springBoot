package com.xxx.muluofeng.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/1/10.
 */
@Controller
@RequestMapping("admin")
public class AdminController {
    @RequestMapping("/login")
    public String login(){
        return  "admin/login";
    }
}
