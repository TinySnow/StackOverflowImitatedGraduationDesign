package com.tinysnow.system.service.impl;

import com.tinysnow.system.service.BestAnswerService;
import com.tinysnow.system.mapper.BestAnswerMapper;
import com.tinysnow.system.model.BestAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * best_answer - 
 *
 * @author Snow
 */
@Service
public class BestAnswerServiceImpl implements BestAnswerService {

    @Autowired
    BestAnswerMapper bestAnswerMapper;


    public int save(BestAnswer bestAnswer){
        return bestAnswerMapper.save(bestAnswer);
    }

    public BestAnswer findList(BestAnswer bestAnswer){
        return bestAnswerMapper.findList(bestAnswer);
    }

    public BestAnswer find(Long id){
        return bestAnswerMapper.find(id);
    }

    public int update(BestAnswer bestAnswer){
        return bestAnswerMapper.update(bestAnswer);
    }

    public int delete(Long id){
        return bestAnswerMapper.delete(id);
    }
}
