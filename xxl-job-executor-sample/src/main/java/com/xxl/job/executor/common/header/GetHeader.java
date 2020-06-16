package com.xxl.job.executor.common.header;

import org.springframework.http.HttpHeaders;

/**
 * 请求头公共方法
 */
public class GetHeader {

    /**
     * 获取请求头
     * @return
     */
    public static HttpHeaders getHeader(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Accept","application/json");
        httpHeaders.add("Content-Type","application/json;charset=UTF-8");
        return httpHeaders;
    }
}
