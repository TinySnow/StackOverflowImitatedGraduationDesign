package com.tinysnow.system.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tinysnow.common.utils.response.ObjectResponse;

import com.tinysnow.common.utils.response.Response;
import com.tinysnow.framework.security.TokenService;
import com.tinysnow.framework.security.annotation.PassLogin;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TokenService tokenService;

    @GetMapping("/login")
    @PassLogin
    public Response login(HttpServletResponse response){
        response.setHeader(tokenService.getHeader(), tokenService.createToken("yangyi"));
        return ObjectResponse.ok(null);
    }

    @GetMapping("/loginno")
    // @PassLogin
    public Response loginno(HttpServletResponse response){
        // response.setHeader(tokenService.getHeader(), tokenService.createToken("yangyi"));
        return ObjectResponse.error("未认证");
    }
}
