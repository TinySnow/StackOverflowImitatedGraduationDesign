package com.tinysnow.system.controller;

import io.mybatis.common.core.DataResponse;
import io.mybatis.common.core.RowsResponse;

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
@RequestMapping("comments")
public class CommentController {

  @Autowired
  private CommentService commentService;

  @PostMapping
  public DataResponse<Comment> save(@RequestBody Comment comment) {
    return DataResponse.ok(commentService.save(comment));
  }

  @GetMapping
  public RowsResponse<Comment> findList(@RequestBody Comment comment) {
    return RowsResponse.ok(commentService.findList(comment));
  }

  @GetMapping(value = "/{id}")
  public DataResponse<Comment> findById(@PathVariable("id") Long id) {
    return DataResponse.ok(commentService.findById(id));
  }

  @PutMapping(value = "/{id}")
  public DataResponse<Comment> update(@PathVariable("id") Long id, @RequestBody Comment comment) {
    comment.setId(id);
    return DataResponse.ok(commentService.update(comment));
  }

  @DeleteMapping(value = "/{id}")
  public DataResponse<Boolean> deleteById(@PathVariable("id") Long id) {
    return DataResponse.ok(commentService.deleteById(id) == 1);
  }

}
