package com.tinysnow.system.service.impl;

import com.tinysnow.system.service.TagService;
import com.tinysnow.system.mapper.TagMapper;
import com.tinysnow.system.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * tag - 
 *
 * @author Snow
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagMapper tagMapper;


    public int save(Tag tag){
        return tagMapper.save(tag);
    }

    public Tag findList(Tag tag){
        return tagMapper.findList(tag);
    }

    public Tag find(Long id){
        return tagMapper.find(id);
    }

    public int update(Tag tag){
        return tagMapper.update(tag);
    }

    public int delete(Long id){
        return tagMapper.delete(id);
    }
}
