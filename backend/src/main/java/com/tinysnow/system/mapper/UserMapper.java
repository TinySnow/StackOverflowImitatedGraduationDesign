package com.tinysnow.system.mapper;

import io.mybatis.mapper.Mapper;

import com.tinysnow.system.model.User;

/**
 * user - 
 *
 * @author Snow
 */
@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User, Long> {

}