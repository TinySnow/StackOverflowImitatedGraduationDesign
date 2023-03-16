package com.tinysnow.system.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.tinysnow.system.model.Question;

import java.util.List;


/**
 * question - 
 *
 * @author Snow
 */
@Mapper
public interface QuestionMapper {

    /**
     * 保存 Question
     */
    public int save(Question question);

    /**
     * 查找全部的 Question
     */
    public Question findList(Question question);

    /**
     * 查找全部 Question
     */
    public List<Question> findAll();

    /**
     * 根据 id 查找 Question
     */
    public Question find(Long id);

    /**
     * 更新 Question
     */
    public int update(Question question);

    /**
     * 根据 id 删除 Question
     */
    public int delete(Long id);

}