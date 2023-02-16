package com.tinysnow.system.service.impl;

import io.mybatis.service.AbstractService;

import com.tinysnow.system.mapper.UsersMapper;
import com.tinysnow.system.model.Users;
import com.tinysnow.system.service.UsersService;

import org.springframework.stereotype.Service;

/**
 * users - 
 *
 * @author Snow
 */
@Service
public class  UsersServiceImpl extends AbstractService<Users, Long, UsersMapper> implements UsersService {

}
