package com.tinysnow.system.mapper;

import com.tinysnow.system.model.Posts;

import io.mybatis.mapper.Mapper;

/**
 * posts - 
 *
 * @author Snow
 */
@org.apache.ibatis.annotations.Mapper
public interface PostsMapper extends Mapper<Posts, Long> {

}