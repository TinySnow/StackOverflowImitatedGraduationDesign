package com.tinysnow.system.controller;

import io.mybatis.common.core.DataResponse;
import io.mybatis.common.core.RowsResponse;

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
@RequestMapping("tags")
public class TagController {

  @Autowired
  private TagService tagService;

  @PostMapping
  public DataResponse<Tag> save(@RequestBody Tag tag) {
    return DataResponse.ok(tagService.save(tag));
  }

  @GetMapping
  public RowsResponse<Tag> findList(@RequestBody Tag tag) {
    return RowsResponse.ok(tagService.findList(tag));
  }

  @GetMapping(value = "/{id}")
  public DataResponse<Tag> findById(@PathVariable("id") Long id) {
    return DataResponse.ok(tagService.findById(id));
  }

  @PutMapping(value = "/{id}")
  public DataResponse<Tag> update(@PathVariable("id") Integer id, @RequestBody Tag tag) {
    tag.setId(id);
    return DataResponse.ok(tagService.update(tag));
  }

  @DeleteMapping(value = "/{id}")
  public DataResponse<Boolean> deleteById(@PathVariable("id") Long id) {
    return DataResponse.ok(tagService.deleteById(id) == 1);
  }

}
