package com.tinysnow.service.impl;

import io.mybatis.service.AbstractService;

import com.tinysnow.service.CollectionsService;
import com.tinysnow.mapper.CollectionsMapper;
import com.tinysnow.model.Collections;
import org.springframework.stereotype.Service;

/**
 * collections - 
 *
 * @author Snow
 */
@Service
public class  CollectionsServiceImpl extends AbstractService<Collections, Long, CollectionsMapper> implements CollectionsService {

}
