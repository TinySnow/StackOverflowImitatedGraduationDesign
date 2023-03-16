package com.tinysnow.system.model;

import lombok.Data;

import java.util.Date;

/**
 * user -
 *
 * @author Snow
 */
@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String avatar;
    private String email;
    private Boolean gender;
    private Date birthday;
    private Date registerTime;
}
