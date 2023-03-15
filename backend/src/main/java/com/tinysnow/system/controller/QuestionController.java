package com.tinysnow.system.controller;

import com.tinysnow.common.utils.response.Response;

import com.tinysnow.system.model.Question;
import com.tinysnow.system.service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

  @PostMapping
  public Response save(@RequestBody Question question) {
    return Response.success(questionService.save(question));
  }

  @GetMapping
  public Response findList() {
    Question question = new Question();
    return Response.success(questionService.findList(question));
  }

  @GetMapping(value = "/{id}")
  public Response find(@PathVariable("id") Long id) {
    return Response.success(questionService.findById(id));
  }

  @PutMapping(value = "/{id}")
  public Response update(@PathVariable("id") Long id, @RequestBody Question question) {
    question.setId(id);
    return Response.success(questionService.update(question));
  }

  @DeleteMapping(value = "/{id}")
  public Response delete(@PathVariable("id") Long id) {
    return Response.success(questionService.deleteById(id) == 1);
  }

}
