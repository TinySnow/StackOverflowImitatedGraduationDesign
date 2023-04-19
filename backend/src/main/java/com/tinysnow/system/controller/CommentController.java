package com.tinysnow.system.controller;

import com.tinysnow.common.utils.response.Response;

import com.tinysnow.framework.security.util.LoginUser;
import com.tinysnow.system.model.Comment;
import com.tinysnow.system.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
  public Response save(HttpServletRequest request, @RequestBody Comment comment) {
    LoginUser o = (LoginUser)request.getAttribute("LoginUser");
    comment.setAuthor(o.getUserId().toString());
    return Response.success(commentService.save(comment));
  }

  @GetMapping("/pass")
  public Response findList() {
    return Response.success(commentService.findAll());
  }

  @GetMapping(value = "/no-pass/author-all/{id}")
  public Response findAllOfOneAuthor(@PathVariable("id") Long userId) {
    return Response.success(commentService.findAllOfOneAuthor(userId));
  }

  @GetMapping(value = "/pass/{id}")
  public Response find(@PathVariable("id") Long id) {
    return Response.success(commentService.find(id));
  }

  @PutMapping(value = "/no-pass")
  public Response update(@RequestBody Comment comment) {
    return Response.success(commentService.update(comment));
  }

  @DeleteMapping(value = "/{id}")
  public Response delete(@PathVariable("id") Long id) {
    return Response.success(commentService.delete(id) == 1);
  }

}
