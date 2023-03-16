package com.tinysnow.system.dto;

import com.tinysnow.system.model.User;

import lombok.Data;

@Data
public class UserDto {
    public User user;
    public Long point;
}
