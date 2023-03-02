package com.tinysnow.system.service.impl;

import io.mybatis.service.AbstractService;

import com.tinysnow.system.service.CommentService;
import com.tinysnow.system.mapper.CommentMapper;
import com.tinysnow.system.model.Comment;
import org.springframework.stereotype.Service;

/**
 * comment - 
 *
 * @author Snow
 */
@Service
public class  CommentServiceImpl extends AbstractService<Comment, Long, CommentMapper> implements CommentService {

}
