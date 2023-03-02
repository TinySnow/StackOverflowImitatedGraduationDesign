package com.tinysnow.system.mapper;

import io.mybatis.mapper.Mapper;

import com.tinysnow.system.model.Post;

/**
 * post - 
 *
 * @author Snow
 */
@org.apache.ibatis.annotations.Mapper
public interface PostMapper extends Mapper<Post, Long> {

}