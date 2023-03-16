package com.tinysnow.system.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.tinysnow.system.model.Comment;


/**
 * comment - 
 *
 * @author Snow
 */
@Mapper
public interface CommentMapper {

    /**
     * 保存 Comment
     */
    public Comment save(Comment comment);

    /**
     * 查找全部的 Comment
     */
    public Comment findList(Comment comment);

    /**
     * 根据 id 查找 Comment
     */
    public Comment find(Long id);

    /**
     * 更新 Comment
     */
    public Comment update(Comment comment);

    /**
     * 根据 id 删除 Comment
     */
    public int delete(Long id);

}