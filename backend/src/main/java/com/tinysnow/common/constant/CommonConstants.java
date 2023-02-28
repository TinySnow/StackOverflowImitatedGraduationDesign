package com.tinysnow.common.constant;

import io.jsonwebtoken.Claims;

/**
 * 常见常量
 * 
 * @author TinySnow
 */
public class CommonConstants {
    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * GBK 字符集
     */
    public static final String GBK = "GBK";

    /**
     * www 主域
     */
    public static final String WWW = "www.";

    /**
     * http 请求
     */
    public static final String HTTP = "http://";

    /**
     * https 请求
     */
    public static final String HTTPS = "https://";

    /**
     * 通用成功标识
     */
    public static final String SUCCESS = "0";

    /**
     * 通用失败标识
     */
    public static final String FAIL = "1";

    /**
     * 登录成功
     */
    public static final String LOGIN_SUCCESS = "登录成功";

    /**
     * 注销
     */
    public static final String LOGOUT = "注销";

    /**
     * 注册
     */
    public static final String REGISTER = "注册";

    /**
     * 登录失败
     */
    public static final String LOGIN_FAIL = "登录失败";

    /**
     * 令牌
     */
    public static final String TOKEN = "token";

    /**
     * token 前缀
     */
    public static final String TOKEN_PREFIX = "Ancielin = ";

    /**
     * 令牌前缀
     */
    public static final String LOGIN_USER_KEY = "login_user_key";

    /**
     * 用户 ID
     */
    public static final String JWT_USERID = "userid";

    /**
     * 用户名称
     */
    public static final String JWT_USERNAME = Claims.SUBJECT;

    /**
     * 用户头像
     */
    public static final String JWT_AVATAR = "avatar";

    /**
     * 创建时间
     */
    public static final String JWT_CREATED = "created";

    /**
     * 用户权限
     */
    public static final String JWT_AUTHORITIES = "authorities";

    /**
     * 资源映射路径 前缀
     */
    public static final String RESOURCE_PREFIX = "/profile";

}
