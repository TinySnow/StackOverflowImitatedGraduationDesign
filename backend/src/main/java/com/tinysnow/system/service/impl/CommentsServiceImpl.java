package com.tinysnow.system.service.impl;

import io.mybatis.service.AbstractService;

import com.tinysnow.system.service.CommentsService;
import com.tinysnow.system.mapper.CommentsMapper;
import com.tinysnow.system.model.Comments;
import org.springframework.stereotype.Service;

/**
 * comments - 
 *
 * @author Snow
 */
@Service
public class  CommentsServiceImpl extends AbstractService<Comments, Long, CommentsMapper> implements CommentsService {

}
