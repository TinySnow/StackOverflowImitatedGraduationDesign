package com.tinysnow.system.controller;

import io.mybatis.common.core.DataResponse;
import io.mybatis.common.core.RowsResponse;

import com.tinysnow.system.model.User;
import com.tinysnow.system.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * user - 
 *
 * @author Snow
 */
@RestController
@RequestMapping("users")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping
  public DataResponse<User> save(@RequestBody User user) {
    return DataResponse.ok(userService.save(user));
  }

  @GetMapping
  public RowsResponse<User> findList(@RequestBody User user) {
    return RowsResponse.ok(userService.findList(user));
  }

  @GetMapping(value = "/{id}")
  public DataResponse<User> findById(@PathVariable("id") Long id) {
    return DataResponse.ok(userService.findById(id));
  }

  @PutMapping(value = "/{id}")
  public DataResponse<User> update(@PathVariable("id") Long id, @RequestBody User user) {
    user.setId(id);
    return DataResponse.ok(userService.update(user));
  }

  @DeleteMapping(value = "/{id}")
  public DataResponse<Boolean> deleteById(@PathVariable("id") Long id) {
    return DataResponse.ok(userService.deleteById(id) == 1);
  }

}
