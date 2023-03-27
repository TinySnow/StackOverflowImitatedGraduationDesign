package com.tinysnow.system.controller;

import com.tinysnow.common.utils.response.Response;

import com.tinysnow.system.model.BestAnswer;
import com.tinysnow.system.service.BestAnswerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * best_answer - 
 *
 * @author Snow
 */
@RestController
@RequestMapping("best-answer")
public class BestAnswerController {

  @Autowired
  private BestAnswerService bestAnswerService;

  @PostMapping
  public Response save(@RequestBody BestAnswer bestAnswer) {
    return Response.success(bestAnswerService.save(bestAnswer));
  }

  @GetMapping
  public Response findList() {
    BestAnswer bestAnswer = new BestAnswer();
    return Response.success(bestAnswerService.findList(bestAnswer));
  }

  @GetMapping(value = "/pass/{id}")
  public Response find(@PathVariable("id") Long id) {
    return Response.success(bestAnswerService.find(id));
  }

  @PutMapping(value = "/{id}")
  public Response update(@PathVariable("id") Long id, @RequestBody BestAnswer bestAnswer) {
    bestAnswer.setBestAnswerId(id);
    return Response.success(bestAnswerService.update(bestAnswer));
  }

  @DeleteMapping(value = "/{id}")
  public Response delete(@PathVariable("id") Long id) {
    return Response.success(bestAnswerService.delete(id) == 1);
  }

}
