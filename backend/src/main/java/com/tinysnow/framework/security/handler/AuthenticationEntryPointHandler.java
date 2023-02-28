package com.tinysnow.framework.security.handler;

import java.io.IOException;
import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinysnow.common.constant.HttpStatus;
import com.tinysnow.common.utils.others.ServletUtil;
import com.tinysnow.common.utils.response.Response;
import com.tinysnow.common.utils.strings.StringUtil;

@Component
public class AuthenticationEntryPointHandler implements AuthenticationEntryPoint, Serializable {

    @Autowired
    ObjectMapper mapper;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
            throws IOException {
        int code = HttpStatus.UNAUTHORIZED;
        String msg = StringUtil.format("请求访问：{} 失败，无法访问系统资源", request.getRequestURI());
        ServletUtil.renderString(response, mapper.writeValueAsString(Response.error(code, msg)));
    }
}
