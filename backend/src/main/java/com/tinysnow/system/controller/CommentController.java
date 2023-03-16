package com.tinysnow.system.controller;

import com.tinysnow.common.utils.response.Response;

import com.tinysnow.system.model.Comment;
import com.tinysnow.system.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * comment - 
 *
 * @author Snow
 */
@RestController
@RequestMapping("comment")
public class CommentController {

  @Autowired
  private CommentService commentService;

  @PostMapping
  public Response save(@RequestBody Comment comment) {
    return Response.success(commentService.save(comment));
  }

  @GetMapping
  public Response findList() {
    Comment comment = new Comment();
    return Response.success(commentService.findList(comment));
  }

  @GetMapping(value = "/{id}")
  public Response find(@PathVariable("id") Long id) {
    return Response.success(commentService.find(id));
  }

  @PutMapping(value = "/{id}")
  public Response update(@PathVariable("id") Long id, @RequestBody Comment comment) {
    comment.setId(id);
    return Response.success(commentService.update(comment));
  }

  @DeleteMapping(value = "/{id}")
  public Response delete(@PathVariable("id") Long id) {
    return Response.success(commentService.delete(id) == 1);
  }

}
