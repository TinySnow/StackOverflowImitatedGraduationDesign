package com.tinysnow.system.service;

import com.tinysnow.system.model.BestAnswer;

/**
 * best_answer - 
 *
 * @author Snow
 */
public interface BestAnswerService {

    /**
     * 保存 BestAnswer
     */
    public BestAnswer save(BestAnswer bestAnswer);

    /**
     * 查找全部的 BestAnswer
     */
    public BestAnswer findList(BestAnswer bestAnswer);

    /**
     * 根据 id 查找 BestAnswer
     */
    public BestAnswer find(Long id);

    /**
     * 更新 BestAnswer
     */
    public BestAnswer update(BestAnswer bestAnswer);

    /**
     * 根据 id 删除 BestAnswer
     */
    public int delete(Long id);
}
