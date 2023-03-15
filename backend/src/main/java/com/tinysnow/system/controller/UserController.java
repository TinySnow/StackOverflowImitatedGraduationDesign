package com.tinysnow.system.controller;

import com.tinysnow.common.utils.response.Response;
import com.tinysnow.framework.security.service.TokenService;
import com.tinysnow.system.model.User;
import com.tinysnow.system.service.UserService;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * user - 
 *
 * @author Snow
 */
@RestController
@RequestMapping("user")
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private TokenService tokenService;

  @PostMapping
  public Response save(@RequestBody User user) {
    return Response.success(userService.save(user));
  }

  @GetMapping
  public Response findList() {
    User user = new User();
    return Response.success(userService.findList(user));
  }
  @GetMapping(value = "/info")
  public Response info(HttpServletRequest request) {
    return Response.success("用户信息",tokenService.getLoginUser(request));
  }

  @GetMapping(value = "/{id}")
  public Response find(@PathVariable("id") Long id) {
    return Response.success(userService.findById(id));
  }

  @PutMapping(value = "/{id}")
  public Response update(@PathVariable("id") Long id, @RequestBody User user) {
    user.setId(id);
    return Response.success(userService.update(user));
  }

  @DeleteMapping(value = "/{id}")
  public Response delete(@PathVariable("id") Long id) {
    return Response.success(userService.deleteById(id) == 1);
  }

}
