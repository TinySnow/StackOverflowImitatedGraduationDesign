package com.tinysnow.system.service.impl;

import io.mybatis.service.AbstractService;

import com.tinysnow.system.service.TagService;
import com.tinysnow.system.mapper.TagMapper;
import com.tinysnow.system.model.Tag;
import org.springframework.stereotype.Service;

/**
 * tag - 
 *
 * @author Snow
 */
@Service
public class  TagServiceImpl extends AbstractService<Tag, Long, TagMapper> implements TagService {

}
