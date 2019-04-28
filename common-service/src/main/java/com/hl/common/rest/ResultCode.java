package com.hl.common.rest;

/**
 * 响应码枚举，参考HTTP状态码的语义
 */
public class ResultCode {
	
    public static final String SUCCESS = "200";//成功
    public static final String FAIL = "400";//失败
    public static final String UNAUTHORIZED = "401";//未认证（签名错误）
    public static final String NOT_FOUND = "404";//接口不存在
    public static final String INTERNAL_SERVER_ERROR = "500";//服务器内部错误
    
}
