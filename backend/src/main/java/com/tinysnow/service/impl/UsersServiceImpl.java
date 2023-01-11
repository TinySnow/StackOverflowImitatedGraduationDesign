package com.tinysnow.service.impl;

import io.mybatis.service.AbstractService;

import com.tinysnow.service.UsersService;
import com.tinysnow.mapper.UsersMapper;
import com.tinysnow.model.Users;
import org.springframework.stereotype.Service;

/**
 * users - 
 *
 * @author Snow
 */
@Service
public class  UsersServiceImpl extends AbstractService<Users, Long, UsersMapper> implements UsersService {

}
