package com.tinysnow.system.service.impl;

import io.mybatis.service.AbstractService;

import com.tinysnow.system.service.PointService;
import com.tinysnow.system.mapper.PointMapper;
import com.tinysnow.system.model.Point;
import org.springframework.stereotype.Service;

/**
 * point - 
 *
 * @author Snow
 */
@Service
public class  PointServiceImpl extends AbstractService<Point, Long, PointMapper> implements PointService {

}
