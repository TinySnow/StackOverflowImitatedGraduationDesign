package com.tinysnow.system.mapper;

import io.mybatis.mapper.Mapper;

import com.tinysnow.system.model.Question;

/**
 * question - 
 *
 * @author Snow
 */
@org.apache.ibatis.annotations.Mapper
public interface QuestionMapper extends Mapper<Question, Long> {

}