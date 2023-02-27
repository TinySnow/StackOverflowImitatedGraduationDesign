package com.tinysnow.system.controller;

import io.mybatis.common.core.DataResponse;
import io.mybatis.common.core.RowsResponse;

import com.tinysnow.system.model.Posts;
import com.tinysnow.system.service.PostsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * posts - 
 *
 * @author Snow
 */
@RestController
@RequestMapping("postses")
public class PostsController {

  @Autowired
  private PostsService postsService;

  @PostMapping
  public DataResponse<Posts> save(@RequestBody Posts posts) {
    return DataResponse.ok(postsService.save(posts));
  }

  @GetMapping
  public RowsResponse<Posts> findList(@RequestBody Posts posts) {
    return RowsResponse.ok(postsService.findList(posts));
  }

  @GetMapping(value = "/{id}")
  public DataResponse<Posts> findById(@PathVariable("id") Long id) {
    return DataResponse.ok(postsService.findById(id));
  }

  @PutMapping(value = "/{id}")
  public DataResponse<Posts> update(@PathVariable("id") Long id, @RequestBody Posts posts) {
    posts.setId(id);
    return DataResponse.ok(postsService.update(posts));
  }

  @DeleteMapping(value = "/{id}")
  public DataResponse<Boolean> deleteById(@PathVariable("id") Long id) {
    return DataResponse.ok(postsService.deleteById(id) == 1);
  }

}
