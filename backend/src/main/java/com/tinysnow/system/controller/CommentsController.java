package com.tinysnow.system.controller;

import io.mybatis.common.core.DataResponse;
import io.mybatis.common.core.RowsResponse;

import com.tinysnow.system.model.Comments;
import com.tinysnow.system.service.CommentsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * comments - 
 *
 * @author Snow
 */
@RestController
@RequestMapping("commentses")
public class CommentsController {

  @Autowired
  private CommentsService commentsService;

  @PostMapping
  public DataResponse<Comments> save(@RequestBody Comments comments) {
    return DataResponse.ok(commentsService.save(comments));
  }

  @GetMapping
  public RowsResponse<Comments> findList(@RequestBody Comments comments) {
    return RowsResponse.ok(commentsService.findList(comments));
  }

  @GetMapping(value = "/{id}")
  public DataResponse<Comments> findById(@PathVariable("id") Long id) {
    return DataResponse.ok(commentsService.findById(id));
  }

  @PutMapping(value = "/{id}")
  public DataResponse<Comments> update(@PathVariable("id") Long id, @RequestBody Comments comments) {
    comments.setId(id);
    return DataResponse.ok(commentsService.update(comments));
  }

  @DeleteMapping(value = "/{id}")
  public DataResponse<Boolean> deleteById(@PathVariable("id") Long id) {
    return DataResponse.ok(commentsService.deleteById(id) == 1);
  }

}
