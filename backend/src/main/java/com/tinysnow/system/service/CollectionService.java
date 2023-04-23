package com.tinysnow.system.service;

import com.tinysnow.system.dto.CollectionDto;
import com.tinysnow.system.model.Collection;

import java.util.List;

/**
 * collection - 
 *
 * @author Snow
 */
public interface CollectionService {

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
    int update(Collection collection);

    /**
     * 根据 id 删除 Collection
     */
    int delete(Long id);
}
