package com.tinysnow.service.impl;

import io.mybatis.service.AbstractService;

import com.tinysnow.service.CommentsService;
import com.tinysnow.mapper.CommentsMapper;
import com.tinysnow.model.Comments;
import org.springframework.stereotype.Service;

/**
 * comments - 
 *
 * @author Snow
 */
@Service
public class  CommentsServiceImpl extends AbstractService<Comments, Long, CommentsMapper> implements CommentsService {

}
