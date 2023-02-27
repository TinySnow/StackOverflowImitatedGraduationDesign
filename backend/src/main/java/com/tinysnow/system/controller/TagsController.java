package com.tinysnow.system.controller;

import io.mybatis.common.core.DataResponse;
import io.mybatis.common.core.RowsResponse;

import com.tinysnow.system.model.Tags;
import com.tinysnow.system.service.TagsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * tags - 
 *
 * @author Snow
 */
@RestController
@RequestMapping("tagses")
public class TagsController {

  @Autowired
  private TagsService tagsService;

  @PostMapping
  public DataResponse<Tags> save(@RequestBody Tags tags) {
    return DataResponse.ok(tagsService.save(tags));
  }

  @GetMapping
  public RowsResponse<Tags> findList(@RequestBody Tags tags) {
    return RowsResponse.ok(tagsService.findList(tags));
  }

  @GetMapping(value = "/{id}")
  public DataResponse<Tags> findById(@PathVariable("id") Long id) {
    return DataResponse.ok(tagsService.findById(id));
  }

  @PutMapping(value = "/{id}")
  public DataResponse<Tags> update(@PathVariable("id") Long id, @RequestBody Tags tags) {
    tags.setId(Math.toIntExact(id));
    return DataResponse.ok(tagsService.update(tags));
  }

  @DeleteMapping(value = "/{id}")
  public DataResponse<Boolean> deleteById(@PathVariable("id") Long id) {
    return DataResponse.ok(tagsService.deleteById(id) == 1);
  }

}
