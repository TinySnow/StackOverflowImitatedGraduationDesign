package com.tinysnow.system.dto;

import com.tinysnow.system.model.Point;
import com.tinysnow.system.model.User;

import lombok.Data;


@Data
public class UserDto {
    private User user;
    private Point point;
}
