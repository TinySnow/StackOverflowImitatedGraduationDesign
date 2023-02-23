package com.tinysnow.system.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tinysnow.common.utils.response.ObjectResponse;

import com.tinysnow.common.utils.response.Response;
import com.tinysnow.framework.security.TokenService;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/test")
public class TestController {

//    @Autowired
//    private TokenService tokenService;

    @GetMapping("/login")
    public Response login(HttpServletResponse response){
//        response.setHeader(tokenService.getHeader(), tokenService.createToken("yangyi"));
        return ObjectResponse.ok(null);
    }

    @GetMapping("/loginno")
    public Response loginno(HttpServletResponse response){
        // response.setHeader(tokenService.getHeader(), tokenService.createToken("yangyi"));
        return ObjectResponse.error("未认证");
    }
}
