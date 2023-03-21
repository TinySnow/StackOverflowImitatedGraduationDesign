package com.tinysnow.system.mapper;

import com.tinysnow.system.dto.CommentDto;
import org.apache.ibatis.annotations.Mapper;

import com.tinysnow.system.model.Comment;

import java.util.List;


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
    int save(Comment comment);

    /**
     * 查找全部的 Comment
     */
    Comment findList(Comment comment);

    List<Comment> findByOneColumn(String column, String value);

    List<CommentDto> findComments(String questionId);

    /**
     * 根据 id 查找 Comment
     */
    Comment find(Long id);

    /**
     * 更新 Comment
     */
    int update(Comment comment);

    /**
     * 根据 id 删除 Comment
     */
    int delete(Long id);

    List<Comment> findAllOfOneAuthor(Long userId);
}