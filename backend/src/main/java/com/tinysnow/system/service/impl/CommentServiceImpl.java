package com.tinysnow.system.service.impl;

import com.tinysnow.system.service.CommentService;
import com.tinysnow.system.mapper.CommentMapper;
import com.tinysnow.system.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * comment - 
 *
 * @author Snow
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;


    public Comment save(Comment comment){
        return commentMapper.save(comment);
    }

    public Comment findList(Comment comment){
        return commentMapper.findList(comment);
    }

    public Comment find(Long id){
        return commentMapper.find(id);
    }

    public Comment update(Comment comment){
        return commentMapper.update(comment);
    }

    public int delete(Long id){
        return commentMapper.delete(id);
    }
}
