package com.tinysnow.system.controller;

import com.tinysnow.common.utils.response.Response;

import com.tinysnow.framework.security.util.LoginUser;
import com.tinysnow.system.model.Question;
import com.tinysnow.system.service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * question - 
 *
 * @author Snow
 */
@RestController
@RequestMapping("question")
public class QuestionController {

  @Autowired
  private QuestionService questionService;

  @PostMapping("/no-pass")
  public Response save(HttpServletRequest request, @RequestBody Question question) {
    LoginUser o = (LoginUser)request.getAttribute("LoginUser");
    question.setAuthor(o.getUserId().toString());
    return Response.success(questionService.save(question));
  }

  @GetMapping("/pass")
  public Response findList() {
    Question question = new Question();
    return Response.success(questionService.findList(question));
  }

  @GetMapping(value = "/pass/{id}/author")
  public Response findAuthor(@PathVariable("id") Long id) {
    return Response.success(questionService.findAuthor(id));
  }

  @GetMapping(value = "/no-pass/author-all/{id}")
  public Response findAllOfOneAuthor(@PathVariable("id") Long userId) {
    return Response.success(questionService.findAllOfOneAuthor(userId));
  }



  @GetMapping(value = "/pass/{id}")
  public Response find(@PathVariable("id") Long id) {
    return Response.success(questionService.find(id));
  }

  @PutMapping(value = "/no-pass/{id}")
  public Response update(@PathVariable("id") Long id, @RequestBody Question question) {
    question.setId(id);
    return Response.success(questionService.update(question));
  }

  @DeleteMapping(value = "/no-pass/{id}")
  public Response delete(@PathVariable("id") Long id) {
    return Response.success(questionService.delete(id) == 1);
  }

}
