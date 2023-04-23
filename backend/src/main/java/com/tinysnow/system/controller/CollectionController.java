package com.tinysnow.system.controller;

import com.tinysnow.common.utils.response.Response;

import com.tinysnow.system.model.Collection;
import com.tinysnow.system.service.CollectionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * collection - 
 *
 * @author Snow
 */
@RestController
@RequestMapping("collection")
public class CollectionController {

  @Autowired
  private CollectionService collectionService;

  @PostMapping
  public Response save(@RequestBody Collection collection) {
    return Response.success(collectionService.save(collection));
  }

  @GetMapping(value = "/no-pass/user/{id}")
  public Response findList(@PathVariable("id") Long id) {
    return Response.success(collectionService.findList(id));
  }

  @GetMapping(value = "/no-pass/{id}")
  public Response find(@PathVariable("id") Long id) {
    return Response.success(collectionService.find(id));
  }

  @PutMapping(value = "/{id}")
  public Response update(@PathVariable("id") Long id, @RequestBody Collection collection) {
    collection.setId(id);
    return Response.success(collectionService.update(collection));
  }

  @DeleteMapping(value = "/{id}")
  public Response delete(@PathVariable("id") Long id) {
    return Response.success(collectionService.delete(id) == 1);
  }

}
