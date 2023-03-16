package com.tinysnow.system.controller;

import com.tinysnow.common.utils.response.Response;

import com.tinysnow.system.model.Tag;
import com.tinysnow.system.service.TagService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * tag - 
 *
 * @author Snow
 */
@RestController
@RequestMapping("tag")
public class TagController {

  @Autowired
  private TagService tagService;

  @PostMapping
  public Response save(@RequestBody Tag tag) {
    return Response.success(tagService.save(tag));
  }

  @GetMapping
  public Response findList() {
    Tag tag = new Tag();
    return Response.success(tagService.findList(tag));
  }

  @GetMapping(value = "/{id}")
  public Response find(@PathVariable("id") Long id) {
    return Response.success(tagService.find(id));
  }

  @PutMapping(value = "/{id}")
  public Response update(@PathVariable("id") Long id, @RequestBody Tag tag) {
    tag.setId(id);
    return Response.success(tagService.update(tag));
  }

  @DeleteMapping(value = "/{id}")
  public Response delete(@PathVariable("id") Long id) {
    return Response.success(tagService.delete(id) == 1);
  }

}
