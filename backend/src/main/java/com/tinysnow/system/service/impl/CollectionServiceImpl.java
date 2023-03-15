package com.tinysnow.system.service.impl;

import io.mybatis.service.AbstractService;

import com.tinysnow.system.service.CollectionService;
import com.tinysnow.system.mapper.CollectionMapper;
import com.tinysnow.system.model.Collection;
import org.springframework.stereotype.Service;

/**
 * collection - 
 *
 * @author Snow
 */
@Service
public class  CollectionServiceImpl extends AbstractService<Collection, Long, CollectionMapper> implements CollectionService {

}
