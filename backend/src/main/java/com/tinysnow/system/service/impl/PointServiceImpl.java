package com.tinysnow.system.service.impl;

import com.tinysnow.system.service.PointService;
import com.tinysnow.system.mapper.PointMapper;
import com.tinysnow.system.model.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * point - 
 *
 * @author Snow
 */
@Service
public class PointServiceImpl implements PointService {

    @Autowired
    PointMapper pointMapper;


    public Point save(Point point){
        return pointMapper.save(point);
    }

    public Point findList(Point point){
        return pointMapper.findList(point);
    }

    public Point find(Long id){
        return pointMapper.find(id);
    }

    public Point update(Point point){
        return pointMapper.update(point);
    }

    public int delete(Long id){
        return pointMapper.delete(id);
    }
}
