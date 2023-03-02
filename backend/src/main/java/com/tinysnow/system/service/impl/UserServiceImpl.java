package com.tinysnow.system.service.impl;

import io.mybatis.service.AbstractService;

import com.tinysnow.system.service.UserService;
import com.tinysnow.system.mapper.UserMapper;
import com.tinysnow.system.model.User;
import org.springframework.stereotype.Service;

/**
 * user - 
 *
 * @author Snow
 */
@Service
public class  UserServiceImpl extends AbstractService<User, Long, UserMapper> implements UserService {

}
