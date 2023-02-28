package com.tinysnow.framework.security.util;

import lombok.Data;

/**
 * 用户登录对象
 * 
 * @author TinySnow
 */
@Data
public class LoginBody {

    /**
     * 用户名
     */
    private String email;

    /**
     * 用户密码
     */
    private String password;

    // /**
    //  * 唯一标识
    //  */
    // private String id;

    // /**
    // * 验证码
    // */
    // private String code;
}
