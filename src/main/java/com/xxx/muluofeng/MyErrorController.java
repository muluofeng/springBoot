package com.xxx.muluofeng;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/29.
 */
@Controller
public class MyErrorController implements ErrorController {

    @Override
    public String getErrorPath() {
        return null;
    }


    private ErrorAttributes errorAttributes;


    /**
     * 初始化ExceptionController
     *
     * @param errorAttributes
     */
    @Autowired
    public MyErrorController(ErrorAttributes errorAttributes) {
        Assert.notNull(errorAttributes, "ErrorAttributes must not be null");
        this.errorAttributes = errorAttributes;
    }


    /**
     * 定义404的ModelAndView
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/error")
    @ResponseBody
    public String errorHtml(HttpServletRequest request,
                                     HttpServletResponse response) {

        Map<String, Object> model = getErrorAttributes(request);

        System.out.println(model);
        return "ERROR";
    }

    /**
     * 获取错误的信息
     *
     * @param request
     * @return
     */
    private Map<String, Object> getErrorAttributes(HttpServletRequest request) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return this.errorAttributes.getErrorAttributes(requestAttributes,
                true);
    }


}
