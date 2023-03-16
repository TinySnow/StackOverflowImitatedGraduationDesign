package com.tinysnow.system.service;

import com.tinysnow.system.model.Collection;

/**
 * collection - 
 *
 * @author Snow
 */
public interface CollectionService {

    /**
     * 保存 Collection
     */
    public int save(Collection collection);

    /**
     * 查找全部的 Collection
     */
    public Collection findList(Collection collection);

    /**
     * 根据 id 查找 Collection
     */
    public Collection find(Long id);

    /**
     * 更新 Collection
     */
    public int update(Collection collection);

    /**
     * 根据 id 删除 Collection
     */
    public int delete(Long id);
}
