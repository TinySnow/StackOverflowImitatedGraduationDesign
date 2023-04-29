package com.tinysnow.system.controller;

import com.tinysnow.common.utils.response.Response;

import com.tinysnow.system.model.Collection;
import com.tinysnow.system.model.CollectionQuestionRelation;
import com.tinysnow.system.service.CollectionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

    @PostMapping("/no-pass/add-question")
    public Response save(@RequestBody CollectionQuestionRelation cqr) {
        return Response.success(collectionService.saveToCollection(cqr));
    }

    @GetMapping(value = "/no-pass/user/{id}")
    public Response findList(@PathVariable("id") Long id) {
        return Response.success(collectionService.findList(id));
    }

    @GetMapping(value = "/no-pass/get-questions/{id}")
    public Response getQuestions(@PathVariable("id") Long id) {
        return Response.success(collectionService.getQuestions(id));
    }

    @GetMapping(value = "/no-pass/{id}")
    public Response find(@PathVariable("id") Long id) {
        return Response.success(collectionService.find(id));
    }

    @PutMapping(value = "/no-pass")
    public Response update(@RequestBody CollectionQuestionRelation cqr) {
        return Response.success(collectionService.update(cqr));
    }

    @DeleteMapping(value = "/{id}")
    public Response delete(@PathVariable("id") Long id) {
        return Response.success(collectionService.delete(id) == 1);
    }

}
