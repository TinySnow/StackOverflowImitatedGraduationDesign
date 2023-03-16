package com.tinysnow.system.service;

import com.tinysnow.system.model.Question;

import java.util.List;

/**
 * question - 
 *
 * @author Snow
 */
public interface QuestionService {

    /**
     * 保存 Question
     */
    int save(Question question);

    /**
     * 查找符合条件的全部 Question
     */
    Question findList(Question question);

    /**
     * 查找全部 Question
     */
    List<Question> findAll();

    /**
     * 根据 id 查找 Question
     */
    Question find(Long id);

    /**
     * 更新 Question
     */
    int update(Question question);

    /**
     * 根据 id 删除 Question
     */
    int delete(Long id);
}
