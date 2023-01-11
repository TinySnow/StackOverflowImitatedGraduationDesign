package com.tinysnow.mapper;

import io.mybatis.mapper.Mapper;

import com.tinysnow.model.Posts;

/**
 * posts - 
 *
 * @author Snow
 */
@org.apache.ibatis.annotations.Mapper
public interface PostsMapper extends Mapper<Posts, Long> {

}