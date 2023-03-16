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
    public Point save(Point point);

    /**
     * 查找全部的 Point
     */
    public Point findList(Point point);

    /**
     * 根据 id 查找 Point
     */
    public Point find(Long id);

    /**
     * 更新 Point
     */
    public Point update(Point point);

    /**
     * 根据 id 删除 Point
     */
    public int delete(Long id);
}
