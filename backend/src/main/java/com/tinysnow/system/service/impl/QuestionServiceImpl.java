package com.tinysnow.system.service.impl;

import com.tinysnow.system.service.QuestionService;
import com.tinysnow.system.mapper.QuestionMapper;
import com.tinysnow.system.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * question - 
 *
 * @author Snow
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionMapper questionMapper;


    public int save(Question question){
        return questionMapper.save(question);
    }

    public Question findList(Question question){
        return questionMapper.findList(question);
    }

    /**
     * 查找全部 Question
     */
    public List<Question> findAll(){
        return questionMapper.findAll();
    }

    public Question find(Long id){
        return questionMapper.find(id);
    }

    public int update(Question question){
        return questionMapper.update(question);
    }

    public int delete(Long id){
        return questionMapper.delete(id);
    }
}
