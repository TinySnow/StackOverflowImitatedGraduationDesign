package com.tinysnow.system.service.impl;

import io.mybatis.service.AbstractService;

import com.tinysnow.system.mapper.CollectionsMapper;
import com.tinysnow.system.model.Collections;
import com.tinysnow.system.service.CollectionsService;

import org.springframework.stereotype.Service;

/**
 * collections - 
 *
 * @author Snow
 */
@Service
public class  CollectionsServiceImpl extends AbstractService<Collections, Long, CollectionsMapper> implements CollectionsService {

}
