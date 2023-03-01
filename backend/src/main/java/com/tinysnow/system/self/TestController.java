package com.tinysnow.system.self;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tinysnow.common.utils.response.Response;
import com.tinysnow.system.model.Users;
import com.tinysnow.system.service.UsersService;

import io.mybatis.common.core.DataResponse;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    UsersService usersService;

    @GetMapping("/login")
    public Response login(HttpServletResponse response){
        return Response.success(null);
    }

    @GetMapping("/loginno")
    public Response loginno(HttpServletResponse response){
        return Response.error("未认证");
    }
    
    @PostMapping("/save")
    public DataResponse<Users> save(@RequestBody Users users) {
      return DataResponse.ok(usersService.save(users));
    }
}
