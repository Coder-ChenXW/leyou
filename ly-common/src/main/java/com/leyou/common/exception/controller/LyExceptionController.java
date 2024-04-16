package com.leyou.common.exception.controller;

import com.leyou.common.exception.pojo.LyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: ChenXW
 * @Date:2024/4/16 15:42
 * @Description: 全局异常拦截器
 **/

@ControllerAdvice
public class LyExceptionController {

    @ExceptionHandler(LyException.class)
    @ResponseBody
    public ResponseEntity<LyException> handlerException(LyException e){
        return ResponseEntity.status(e.getStatus()).body(e);
    }

}
