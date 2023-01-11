package com.tinysnow.service.impl;

import io.mybatis.service.AbstractService;

import com.tinysnow.service.PostsService;
import com.tinysnow.mapper.PostsMapper;
import com.tinysnow.model.Posts;
import org.springframework.stereotype.Service;

/**
 * posts - 
 *
 * @author Snow
 */
@Service
public class  PostsServiceImpl extends AbstractService<Posts, Long, PostsMapper> implements PostsService {

}
