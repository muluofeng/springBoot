package com.xxx.muluofeng.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/1/11.
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/test1")
    public String testOne() {
        return "test";
    }
}
