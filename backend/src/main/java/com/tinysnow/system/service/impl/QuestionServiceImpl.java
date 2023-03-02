package com.tinysnow.system.service.impl;

import io.mybatis.service.AbstractService;

import com.tinysnow.system.service.QuestionService;
import com.tinysnow.system.mapper.QuestionMapper;
import com.tinysnow.system.model.Question;
import org.springframework.stereotype.Service;

/**
 * question - 
 *
 * @author Snow
 */
@Service
public class  QuestionServiceImpl extends AbstractService<Question, Long, QuestionMapper> implements QuestionService {

}
