package com.tinysnow.system.self;

// import java.util.List;
// import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tinysnow.common.constant.CommonConstants;
import com.tinysnow.common.constant.HttpStatus;
import com.tinysnow.common.constant.ServiceConstants;
import com.tinysnow.common.utils.response.Response;
import com.tinysnow.framework.security.service.LoginService;
import com.tinysnow.framework.security.util.LoginBody;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/login")
@Tag(name = "测试接口")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public Response body(@RequestBody LoginBody loginBody) {
        // 生成令牌
        String token = loginService.login(loginBody.getEmail(), loginBody.getPassword());
        if (token == null) {
            return Response.error(HttpStatus.NOT_FOUND ,ServiceConstants.EMAIL_NOT_FOUND);
        }else if (token.equals(ServiceConstants.PASSWORD_INCORRECT)) {
            return Response.error(HttpStatus.BAD_REQUEST ,ServiceConstants.PASSWORD_INCORRECT);
        }
        Response response = Response.success();
        response.put(CommonConstants.TOKEN, token);
        return response;
    }
}
