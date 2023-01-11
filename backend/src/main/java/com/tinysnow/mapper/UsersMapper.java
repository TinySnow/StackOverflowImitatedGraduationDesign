package com.tinysnow.mapper;

import io.mybatis.mapper.Mapper;

import com.tinysnow.model.Users;

/**
 * users - 
 *
 * @author Snow
 */
@org.apache.ibatis.annotations.Mapper
public interface UsersMapper extends Mapper<Users, Long> {

}