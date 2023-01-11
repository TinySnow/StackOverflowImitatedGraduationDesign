package com.tinysnow.service.impl;

import io.mybatis.service.AbstractService;

import com.tinysnow.service.TagsService;
import com.tinysnow.mapper.TagsMapper;
import com.tinysnow.model.Tags;
import org.springframework.stereotype.Service;

/**
 * tags - 
 *
 * @author Snow
 */
@Service
public class  TagsServiceImpl extends AbstractService<Tags, Long, TagsMapper> implements TagsService {

}
