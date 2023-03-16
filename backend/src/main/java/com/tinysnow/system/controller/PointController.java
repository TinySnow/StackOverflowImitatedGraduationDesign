package com.tinysnow.system.controller;

import com.tinysnow.common.utils.response.Response;

import com.tinysnow.system.model.Point;
import com.tinysnow.system.service.PointService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * point - 
 *
 * @author Snow
 */
@RestController
@RequestMapping("point")
public class PointController {

  @Autowired
  private PointService pointService;

  @PostMapping
  public Response save(@RequestBody Point point) {
    return Response.success(pointService.save(point));
  }

  @GetMapping
  public Response findList() {
    Point point = new Point();
    return Response.success(pointService.findList(point));
  }

  @GetMapping(value = "/{id}")
  public Response find(@PathVariable("id") Long id) {
    return Response.success(pointService.find(id));
  }

  @PutMapping(value = "/{id}")
  public Response update(@PathVariable("id") Long id, @RequestBody Point point) {
    point.setId(id);
    return Response.success(pointService.update(point));
  }

  @DeleteMapping(value = "/{id}")
  public Response delete(@PathVariable("id") Long id) {
    return Response.success(pointService.delete(id) == 1);
  }

}
