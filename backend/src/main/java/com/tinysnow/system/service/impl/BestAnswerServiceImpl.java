package com.tinysnow.system.service.impl;

import io.mybatis.service.AbstractService;

import com.tinysnow.system.service.BestAnswerService;
import com.tinysnow.system.mapper.BestAnswerMapper;
import com.tinysnow.system.model.BestAnswer;
import org.springframework.stereotype.Service;

/**
 * best_answer - 
 *
 * @author Snow
 */
@Service
public class  BestAnswerServiceImpl extends AbstractService<BestAnswer, Long, BestAnswerMapper> implements BestAnswerService {

}
