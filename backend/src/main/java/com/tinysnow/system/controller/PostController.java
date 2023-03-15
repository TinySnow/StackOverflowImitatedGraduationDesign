package com.tinysnow.system.controller;

import com.tinysnow.common.utils.response.Response;

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
@RequestMapping("post")
public class PostController {

  @Autowired
  private PostService postService;

  @PostMapping
  public Response save(@RequestBody Post post) {
    return Response.success(postService.save(post));
  }

  @GetMapping
  public Response findList() {
    Post post = new Post();
    return Response.success(postService.findList(post));
  }

  @GetMapping(value = "/{id}")
  public Response find(@PathVariable("id") Long id) {
    return Response.success(postService.findById(id));
  }

  @PutMapping(value = "/{id}")
  public Response update(@PathVariable("id") Long id, @RequestBody Post post) {
    post.setId(id);
    return Response.success(postService.update(post));
  }

  @DeleteMapping(value = "/{id}")
  public Response delete(@PathVariable("id") Long id) {
    return Response.success(postService.deleteById(id) == 1);
  }

}
