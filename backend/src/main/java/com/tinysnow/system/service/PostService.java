package com.tinysnow.system.service;

import com.tinysnow.system.model.Post;

/**
 * post - 
 *
 * @author Snow
 */
public interface PostService {

    /**
     * 保存 Post
     */
    public Post save(Post post);

    /**
     * 查找全部的 Post
     */
    public Post findList(Post post);

    /**
     * 根据 id 查找 Post
     */
    public Post find(Long id);

    /**
     * 更新 Post
     */
    public Post update(Post post);

    /**
     * 根据 id 删除 Post
     */
    public int delete(Long id);
}
