package com.xxx.muluofeng;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Administrator on 2016/12/29.
 */
@ControllerAdvice
public class DefaultExceptionHandler {


    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultExceptionHandler.class); //日志记录器

    @ExceptionHandler({MissingServletRequestParameterException.class,
            IllegalArgumentException.class, IllegalStateException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public void conversionErrorHandler(Exception ex) {
        //记录日志
        LOGGER.error("参数异常捕获", ex);

        System.out.println(ex);
    }
}
