package com.tinysnow.system.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.tinysnow.system.model.Post;


/**
 * post - 
 *
 * @author Snow
 */
@Mapper
public interface PostMapper {

    /**
     * 保存 Post
     */
    int save(Post post);

    /**
     * 查找全部的 Post
     */
    Post findList(Post post);

    /**
     * 根据 id 查找 Post
     */
    Post find(Long id);

    /**
     * 更新 Post
     */
    int update(Post post);

    /**
     * 根据 id 删除 Post
     */
    int delete(Long id);

}