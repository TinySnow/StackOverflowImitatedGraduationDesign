package com.tinysnow.system.service;

import com.tinysnow.system.model.Point;

/**
 * point - 
 *
 * @author Snow
 */
public interface PointService {

    /**
     * 保存 Point
     */
    int save(Point point);

    /**
     * 查找全部的 Point
     */
    Point findList(Point point);

    /**
     * 根据 id 查找 Point
     */
    Point find(Long id);

    /**
     * 更新 Point
     */
    int update(Point point);

    /**
     * 根据 id 删除 Point
     */
    int delete(Long id);
}
