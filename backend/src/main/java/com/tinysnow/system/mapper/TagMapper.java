package com.tinysnow.system.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.tinysnow.system.model.Tag;

import java.util.List;


/**
 * tag - 
 *
 * @author Snow
 */
@Mapper
public interface TagMapper {

    /**
     * 保存 Tag
     */
    int save(Tag tag);


    List<Tag> findTagsByQuestionId(Long id);

    /**
     * 查找全部的 Tag
     */
    Tag findList(Tag tag);

    /**
     * 根据 id 查找 Tag
     */
    Tag find(Long id);

    /**
     * 更新 Tag
     */
    int update(Tag tag);

    /**
     * 根据 id 删除 Tag
     */
    int delete(Long id);

}