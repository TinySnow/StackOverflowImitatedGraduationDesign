package com.tinysnow.system.service.impl;

import com.tinysnow.system.service.PostService;
import com.tinysnow.system.mapper.PostMapper;
import com.tinysnow.system.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * post - 
 *
 * @author Snow
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostMapper postMapper;


    public Post save(Post post){
        return postMapper.save(post);
    }

    public Post findList(Post post){
        return postMapper.findList(post);
    }

    public Post find(Long id){
        return postMapper.find(id);
    }

    public Post update(Post post){
        return postMapper.update(post);
    }

    public int delete(Long id){
        return postMapper.delete(id);
    }
}
