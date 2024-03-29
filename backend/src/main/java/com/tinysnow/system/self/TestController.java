package com.tinysnow.system.self;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tinysnow.common.utils.response.Response;
import com.tinysnow.system.model.User;
import com.tinysnow.system.service.CommentService;
import com.tinysnow.system.service.QuestionService;
import com.tinysnow.system.service.UserService;


@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    UserService userService;

    @Autowired
    QuestionService questionService;

    @Autowired
    CommentService commentService;

    @GetMapping("/login")
    public Response login() {
        return Response.success(null);
    }

    @GetMapping("/loginno")
    public Response loginno() {
        return Response.error("未认证");
    }

    @PostMapping("/save")
    public Response save(@RequestBody User users) {
        return Response.success(userService.save(users));
    }

    @GetMapping("/question-lists")
    public Response questionLists() {
        return Response.success("所有问题列表", questionService.findAll());
    }

    @GetMapping(value = "/question-detail/{id}")
    public Response findById(@PathVariable("id") Long id) {
        return Response.success(questionService.find(id));
    }

    @GetMapping("/rank-lists")
    public Response rankLists() {
        return Response.success(userService.findAll());
    }

    @GetMapping("/comments/{questionId}")
    public Response commentLists(@PathVariable("questionId") Long id) {
        return Response.success(commentService.findComments(id.toString()));
    }

    @GetMapping("/user/info")
    public Response getInfo(Long id) {
        return Response.success(userService.find(id));
    }
}
