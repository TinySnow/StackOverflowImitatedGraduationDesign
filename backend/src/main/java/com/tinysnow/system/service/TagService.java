package com.tinysnow.system.service;

import com.tinysnow.system.model.Tag;

/**
 * tag - 
 *
 * @author Snow
 */
public interface TagService {

    /**
     * 保存 Tag
     */
    int save(Tag tag);

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
