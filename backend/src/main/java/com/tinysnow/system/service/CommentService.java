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
    int save(Comment comment);

    /**
     * 查找全部的 Comment
     */
    Comment findList(Comment comment);

    /**
     * 根据 id 查找 Comment
     */
    Comment find(Long id);

    List<Comment> findByOneColumn(String column, String value);

    List<Comment> findComments(String questionId);

    /**
     * 更新 Comment
     */
    int update(Comment comment);

    /**
     * 根据 id 删除 Comment
     */
    int delete(Long id);
}
