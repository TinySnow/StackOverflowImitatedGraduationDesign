package com.tinysnow.system.service;

import com.tinysnow.system.model.Comment;

import java.util.List;

/**
 * comment -
 *
 * @author Snow
 */
public interface CommentService {

    /**
     * 保存 Comment
     */
    public int save(Comment comment);

    /**
     * 查找全部的 Comment
     */
    public Comment findList(Comment comment);

    /**
     * 根据 id 查找 Comment
     */
    public Comment find(Long id);

    public List<Comment> findByOneColumn(String column, String value);

    public List<Comment> findComments(String questionId);

    /**
     * 更新 Comment
     */
    public int update(Comment comment);

    /**
     * 根据 id 删除 Comment
     */
    public int delete(Long id);
}
