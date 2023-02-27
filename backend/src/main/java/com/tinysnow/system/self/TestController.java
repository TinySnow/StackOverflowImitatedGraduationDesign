package com.tinysnow.system.self;
import org.springframework.web.bind.annotation.*;

import com.tinysnow.common.utils.response.Response;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/login")
    public Response login(HttpServletResponse response){
        return Response.success(null);
    }

    @GetMapping("/loginno")
    public Response loginno(HttpServletResponse response){
        return Response.error("未认证");
    }
}
