package com.leyou.common.exception.pojo;

import lombok.Getter;

/**
 * @Author: ChenXW
 * @Date:2024/4/16 15:45
 * @Description: 自定义异常类
 **/
@Getter
public class ExceptionResult {
    private Integer status;
    private String message;

    public ExceptionResult(LyException e){
        this.status = e.getStatus();
        this.message = e.getMessage();
    }
}
