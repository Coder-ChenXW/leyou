package com.leyou.common.exception.pojo;

import lombok.Data;
import lombok.Getter;

/**
 * @Author: ChenXW
 * @Date:2024/4/16 15:40
 * @Description: 自定义异常类
 **/
@Getter
public class LyException extends RuntimeException{
    private Integer status;//状态码

    public LyException(Integer status,String message){
        super(message);
        this.status = status;
    }

    public LyException(ExceptionEnum exceptionEnum){
        super(exceptionEnum.getMessage());
        this.status = exceptionEnum.getStatus();
    }
}

