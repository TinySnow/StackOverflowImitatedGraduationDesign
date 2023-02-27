package com.tinysnow.system.mapper;

import io.mybatis.mapper.Mapper;

import com.tinysnow.system.model.Comments;

/**
 * comments - 
 *
 * @author Snow
 */
@org.apache.ibatis.annotations.Mapper
public interface CommentsMapper extends Mapper<Comments, Long> {

}