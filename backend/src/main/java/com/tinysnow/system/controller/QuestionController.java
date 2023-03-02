package com.tinysnow.system.controller;

import io.mybatis.common.core.DataResponse;
import io.mybatis.common.core.RowsResponse;

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
@RequestMapping("questions")
public class QuestionController {

  @Autowired
  private QuestionService questionService;

  @PostMapping
  public DataResponse<Question> save(@RequestBody Question question) {
    return DataResponse.ok(questionService.save(question));
  }

  @GetMapping
  public RowsResponse<Question> findList(@RequestBody Question question) {
    return RowsResponse.ok(questionService.findList(question));
  }

  @GetMapping(value = "/{id}")
  public DataResponse<Question> findById(@PathVariable("id") Long id) {
    return DataResponse.ok(questionService.findById(id));
  }

  @PutMapping(value = "/{id}")
  public DataResponse<Question> update(@PathVariable("id") Long id, @RequestBody Question question) {
    question.setId(id);
    return DataResponse.ok(questionService.update(question));
  }

  @DeleteMapping(value = "/{id}")
  public DataResponse<Boolean> deleteById(@PathVariable("id") Long id) {
    return DataResponse.ok(questionService.deleteById(id) == 1);
  }

}
