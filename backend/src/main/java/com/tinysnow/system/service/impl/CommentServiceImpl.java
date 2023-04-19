package com.tinysnow.system.service.impl;

import com.tinysnow.system.dto.CommentDto;
import com.tinysnow.system.service.CommentService;
import com.tinysnow.system.mapper.CommentMapper;
import com.tinysnow.system.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * comment -
 *
 * @author Snow
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;


    public int save(Comment comment) {
        return commentMapper.save(comment);
    }

    public Comment findList(Comment comment) {
        return commentMapper.findList(comment);
    }

    public List<Comment> findByOneColumn(String column, String value) {
        return commentMapper.findByOneColumn(column, value);
    }

    public List<CommentDto> findComments(String questionId){
        return commentMapper.findComments(questionId);
    }

    public Comment find(Long id) {
        return commentMapper.find(id);
    }

    public int update(Comment comment) {
        return commentMapper.update(comment);
    }

    public int delete(Long id) {
        return commentMapper.delete(id);
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public List<Comment> findAllOfOneAuthor(Long userId) {
        return commentMapper.findAllOfOneAuthor(userId);
    }

    /**
     * @return
     */
    @Override
    public List<Comment> findAll() {
        return commentMapper.findAll();
    }
}
