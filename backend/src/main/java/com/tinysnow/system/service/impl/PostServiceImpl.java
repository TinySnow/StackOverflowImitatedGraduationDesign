package com.tinysnow.system.service.impl;

import io.mybatis.service.AbstractService;

import com.tinysnow.system.service.PostService;
import com.tinysnow.system.mapper.PostMapper;
import com.tinysnow.system.model.Post;
import org.springframework.stereotype.Service;

/**
 * post - 
 *
 * @author Snow
 */
@Service
public class  PostServiceImpl extends AbstractService<Post, Long, PostMapper> implements PostService {

}
