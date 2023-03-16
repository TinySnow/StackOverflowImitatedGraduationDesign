package com.tinysnow.system.service;

import com.tinysnow.system.model.Question;

/**
 * question - 
 *
 * @author Snow
 */
public interface QuestionService {

    /**
     * 保存 Question
     */
    public Question save(Question question);

    /**
     * 查找符合条件的全部 Question
     */
    public Question findList(Question question);

    /**
     * 查找全部 Question
     */
    public Question findAll();

    /**
     * 根据 id 查找 Question
     */
    public Question find(Long id);

    /**
     * 更新 Question
     */
    public Question update(Question question);

    /**
     * 根据 id 删除 Question
     */
    public int delete(Long id);
}
