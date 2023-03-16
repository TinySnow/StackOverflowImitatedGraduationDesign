package com.tinysnow.system.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.tinysnow.system.model.Tag;


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
    public Tag save(Tag tag);

    /**
     * 查找全部的 Tag
     */
    public Tag findList(Tag tag);

    /**
     * 根据 id 查找 Tag
     */
    public Tag find(Long id);

    /**
     * 更新 Tag
     */
    public Tag update(Tag tag);

    /**
     * 根据 id 删除 Tag
     */
    public int delete(Long id);

}