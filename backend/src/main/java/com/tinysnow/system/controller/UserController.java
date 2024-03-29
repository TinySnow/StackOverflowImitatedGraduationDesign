package com.tinysnow.system.controller;

import com.tinysnow.common.utils.response.Response;

import com.tinysnow.framework.security.util.LoginUser;
import com.tinysnow.system.model.Avatar;
import com.tinysnow.system.model.User;
import com.tinysnow.system.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * user -
 *
 * @author Snow
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/pass")
    public Response save(@RequestBody User user) {
        return Response.success(userService.save(user));
    }

    @GetMapping("/pass")
    public Response findList() {
        return Response.success(userService.findAll());
    }

    @GetMapping("/all/point")
    public Response findListWithPoint() {
        return Response.success(userService.findListsWithPoint());
    }

    @GetMapping(value = "/{id}")
    public Response find(@PathVariable("id") Long id) {
        return Response.success(userService.find(id));
    }

    @PutMapping(value = "/{id}")
    public Response update(@PathVariable("id") Long id, @RequestBody User user) {
        user.setId(id);
        return Response.success(userService.update(user));
    }

    @PutMapping(value = "/no-pass/avatar/{id}")
    public Response updateAvatar(@PathVariable("id") Long id, @RequestBody Avatar avatar) {
        return Response.success(userService.updateAvatar(id, avatar.getUrl()) == 1);
    }

    @PutMapping(value = "/no-pass/profile/{id}")
    public Response updateProfile(@PathVariable("id") Long id, @RequestBody User user) {
        return Response.success(userService.updateProfile(id, user));
    }

    @DeleteMapping(value = "/{id}")
    public Response delete(@PathVariable("id") Long id) {
        return Response.success(userService.delete(id) == 1);
    }

    @GetMapping("/info")
    public Response getProfile(HttpServletRequest request) {
        LoginUser o = (LoginUser) request.getAttribute("LoginUser");
        return Response.success(userService.getProfile(o.getUserId()));
    }
}
