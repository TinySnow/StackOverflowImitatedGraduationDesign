package com.tinysnow.system.mapper;

import io.mybatis.mapper.Mapper;

import com.tinysnow.system.model.Comment;

/**
 * comment - 
 *
 * @author Snow
 */
@org.apache.ibatis.annotations.Mapper
public interface CommentMapper extends Mapper<Comment, Long> {

}