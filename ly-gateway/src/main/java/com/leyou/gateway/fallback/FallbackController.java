package com.leyou.gateway.fallback;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 处理熔断降级
 */
@RestController
public class FallbackController {

    /**
     * 降级方法
     */
    @RequestMapping("/fallback")
    public String fallback(){
        return "服务器繁忙，请稍后再试";
    }
}
