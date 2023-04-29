package com.tinysnow.system.mapper;

import com.tinysnow.system.dto.CollectionDto;
import com.tinysnow.system.model.CollectionQuestionRelation;
import com.tinysnow.system.model.Question;
import org.apache.ibatis.annotations.Mapper;

import com.tinysnow.system.model.Collection;

import java.util.List;


/**
 * collection - 
 *
 * @author Snow
 */
@Mapper
public interface CollectionMapper {

    /**
     * 保存 Collection
     */
    int save(Collection collection);

    /**
     * 查找全部的 Collection
     */
    List<CollectionDto> findList(Long id);

    /**
     * 根据 id 查找 Collection
     */
    Collection find(Long id);

    /**
     * 更新 Collection
     */
    int update(CollectionQuestionRelation cqr);

    /**
     * 根据 id 删除 Collection
     */
    int delete(Long id);

    /**
     * 删除中间表相关数据
     */
    int deleteRelation(Long id);

    /**
     * 添加中间表相关数据
     */
    int saveToCollection(CollectionQuestionRelation cqr);

    List<Question> getQuestions(Long id);
}