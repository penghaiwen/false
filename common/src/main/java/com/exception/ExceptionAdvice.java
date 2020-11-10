package com.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Author 老默
 * @Description  自定义异常捕获
 * @Date 2020/4/29 15:23
 * @param: null
 * @return
 **/
@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {

    /**
     * 自定义异常
     */
    @ExceptionHandler({RestException.class})
    public RestBean restException(RestException rest) throws Exception  {
        System.out.println("1111");
        log.error("RestException: {}, msg: {}", rest.getRet(), rest.getMsg());
        return RestBean.error(rest.getRet(), rest.getMsg(), rest.getData());
    }

    @ExceptionHandler(Exception.class)
    public RestBean exception(Exception e) {
        log.error("Exception type: {}", e.toString());
        log.error("Exception content: {}", Arrays.stream(e.getStackTrace()).limit(8).collect(Collectors.toList()));
        return RestBean.error(e.getLocalizedMessage());
    }
}
