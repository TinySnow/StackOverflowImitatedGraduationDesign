package com.tinysnow.system.controller;

import io.mybatis.common.core.DataResponse;
import io.mybatis.common.core.RowsResponse;

import com.tinysnow.system.model.Post;
import com.tinysnow.system.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * post - 
 *
 * @author Snow
 */
@RestController
@RequestMapping("posts")
public class PostController {

  @Autowired
  private PostService postService;

  @PostMapping
  public DataResponse<Post> save(@RequestBody Post post) {
    return DataResponse.ok(postService.save(post));
  }

  @GetMapping
  public RowsResponse<Post> findList(@RequestBody Post post) {
    return RowsResponse.ok(postService.findList(post));
  }

  @GetMapping(value = "/{id}")
  public DataResponse<Post> findById(@PathVariable("id") Long id) {
    return DataResponse.ok(postService.findById(id));
  }

  @PutMapping(value = "/{id}")
  public DataResponse<Post> update(@PathVariable("id") Long id, @RequestBody Post post) {
    post.setId(id);
    return DataResponse.ok(postService.update(post));
  }

  @DeleteMapping(value = "/{id}")
  public DataResponse<Boolean> deleteById(@PathVariable("id") Long id) {
    return DataResponse.ok(postService.deleteById(id) == 1);
  }

}
