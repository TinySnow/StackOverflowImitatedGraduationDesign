package com.tinysnow.system.service.impl;

import io.mybatis.service.AbstractService;

import com.tinysnow.system.service.TagsService;
import com.tinysnow.system.mapper.TagsMapper;
import com.tinysnow.system.model.Tags;
import org.springframework.stereotype.Service;

/**
 * tags - 
 *
 * @author Snow
 */
@Service
public class  TagsServiceImpl extends AbstractService<Tags, Long, TagsMapper> implements TagsService {

}
