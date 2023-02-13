package com.tinysnow.controller;

import io.mybatis.common.core.DataResponse;
import io.mybatis.common.core.RowsResponse;

import com.tinysnow.model.Users;
import com.tinysnow.service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * users -
 *
 * @author Snow
 */
@RestController
@RequestMapping("userses")
public class UsersController {

  @Autowired
  private UsersService usersService;

  @PostMapping
  public DataResponse<Users> save(@RequestBody Users users) {
    return DataResponse.ok(usersService.save(users));
  }

  @GetMapping
  public RowsResponse<Users> findList() {
    Users users = new Users();
    return RowsResponse.ok(usersService.findList(users));
  }

  @GetMapping(value = "/{id}")
  public DataResponse<Users> findById(@PathVariable("id") Long id) {
    return DataResponse.ok(usersService.findById(id));
  }

  @PutMapping(value = "/{id}")
  public DataResponse<Users> update(@PathVariable("id") Long id, @RequestBody Users users) {
    users.setId(id);
    return DataResponse.ok(usersService.update(users));
  }

  @DeleteMapping(value = "/{id}")
  public DataResponse<Boolean> deleteById(@PathVariable("id") Long id) {
    return DataResponse.ok(usersService.deleteById(id) == 1);
  }

}
