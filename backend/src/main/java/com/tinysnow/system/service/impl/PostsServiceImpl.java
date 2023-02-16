package com.tinysnow.system.service.impl;

import io.mybatis.service.AbstractService;

import com.tinysnow.system.mapper.PostsMapper;
import com.tinysnow.system.model.Posts;
import com.tinysnow.system.service.PostsService;

import org.springframework.stereotype.Service;

/**
 * posts - 
 *
 * @author Snow
 */
@Service
public class  PostsServiceImpl extends AbstractService<Posts, Long, PostsMapper> implements PostsService {

}
