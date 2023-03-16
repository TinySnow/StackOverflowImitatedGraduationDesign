package com.tinysnow.system.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.tinysnow.system.model.Collection;


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
    public Collection save(Collection collection);

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
    public Collection update(Collection collection);

    /**
     * 根据 id 删除 Collection
     */
    public int delete(Long id);

}