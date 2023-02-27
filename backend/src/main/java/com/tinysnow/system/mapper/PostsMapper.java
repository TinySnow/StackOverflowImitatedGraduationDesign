package com.tinysnow.system.mapper;

import io.mybatis.mapper.Mapper;

import com.tinysnow.system.model.Posts;

/**
 * posts - 
 *
 * @author Snow
 */
@org.apache.ibatis.annotations.Mapper
public interface PostsMapper extends Mapper<Posts, Long> {

}