package com.tinysnow.system.controller;

import io.mybatis.common.core.DataResponse;
import io.mybatis.common.core.RowsResponse;

import com.tinysnow.system.model.Collections;
import com.tinysnow.system.service.CollectionsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * collections -
 *
 * @author Snow
 */
@RestController
@RequestMapping("collectionses")
public class CollectionsController {

  @Autowired
  private CollectionsService collectionsService;

  @PostMapping
  public DataResponse<Collections> save(@RequestBody Collections collections) {
    return DataResponse.ok(collectionsService.save(collections));
  }

  @GetMapping
  public RowsResponse<Collections> findList(@RequestBody Collections collections) {
    return RowsResponse.ok(collectionsService.findList(collections));
  }

  @GetMapping(value = "/{id}")
  public DataResponse<Collections> findById(@PathVariable("id") Long id) {
    return DataResponse.ok(collectionsService.findById(id));
  }

  @PutMapping(value = "/{id}")
  public DataResponse<Collections> update(@PathVariable("id") Long id, @RequestBody Collections collections) {
    collections.setId(id);
    return DataResponse.ok(collectionsService.update(collections));
  }

  @DeleteMapping(value = "/{id}")
  public DataResponse<Boolean> deleteById(@PathVariable("id") Long id) {
    return DataResponse.ok(collectionsService.deleteById(id) == 1);
  }

}
