package com.tinysnow.system.service.impl;

import com.tinysnow.system.service.CollectionService;
import com.tinysnow.system.mapper.CollectionMapper;
import com.tinysnow.system.model.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * collection - 
 *
 * @author Snow
 */
@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    CollectionMapper collectionMapper;


    public int save(Collection collection){
        return collectionMapper.save(collection);
    }

    public Collection findList(Collection collection){
        return collectionMapper.findList(collection);
    }

    public Collection find(Long id){
        return collectionMapper.find(id);
    }

    public int update(Collection collection){
        return collectionMapper.update(collection);
    }

    public int delete(Long id){
        return collectionMapper.delete(id);
    }
}
