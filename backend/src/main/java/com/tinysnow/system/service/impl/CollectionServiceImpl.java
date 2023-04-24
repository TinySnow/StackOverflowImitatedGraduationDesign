package com.tinysnow.system.service.impl;

import com.tinysnow.system.dto.CollectionDto;
import com.tinysnow.system.model.CollectionQuestionRelation;
import com.tinysnow.system.service.CollectionService;
import com.tinysnow.system.mapper.CollectionMapper;
import com.tinysnow.system.model.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * collection -
 *
 * @author Snow
 */
@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    CollectionMapper collectionMapper;


    public int save(Collection collection) {
        return collectionMapper.save(collection);
    }

    public List<CollectionDto> findList(Long id) {
        return collectionMapper.findList(id);
    }

    public Collection find(Long id) {
        return collectionMapper.find(id);
    }

    public int update(Collection collection) {
        return collectionMapper.update(collection);
    }

    @Transactional
    public int delete(Long id) {
        collectionMapper.deleteRelation(id);
        return collectionMapper.delete(id);
    }

    @Override
    public int saveToCollection(CollectionQuestionRelation cqr) {
        return collectionMapper.saveToCollection(cqr);
    }
}
