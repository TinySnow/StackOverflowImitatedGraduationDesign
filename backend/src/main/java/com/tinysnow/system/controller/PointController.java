package com.tinysnow.system.controller;

import com.tinysnow.common.utils.response.Response;
import com.tinysnow.framework.security.service.TokenService;
import com.tinysnow.system.model.Point;
import com.tinysnow.system.service.PointService;

import javax.servlet.http.HttpServletRequest;

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
  
  @Autowired
  private TokenService tokenService;

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
    return Response.success(pointService.findById(id));
  }

  @GetMapping(value = "/info")
  public Response info(HttpServletRequest request) {
    return Response.success("用户信息",find(tokenService.getLoginUser(request).getUserId()));
  }

  @PutMapping(value = "/{id}")
  public Response update(@PathVariable("id") Long id, @RequestBody Point point) {
    point.setId(id);
    return Response.success(pointService.update(point));
  }

  @DeleteMapping(value = "/{id}")
  public Response delete(@PathVariable("id") Long id) {
    return Response.success(pointService.deleteById(id) == 1);
  }

}
