package com.tinysnow.framework.security;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.tinysnow.common.utils.response.Response;
// import com.tinysnow.framework.security.annotation.PassLogin;

// import io.jsonwebtoken.Claims;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.util.StringUtils;
// import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
// import org.springframework.web.servlet.ModelAndView;

// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import java.lang.reflect.Method;

public class TokenInterceptor implements HandlerInterceptor {
//     @Autowired
//     private TokenService TokenService;

//     @Autowired
//     private ObjectMapper objectMapper;

//     // 在业务处理请求之前处理
//     @Override
//     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//             throws Exception {
//         // 设置response响应数据类型为json和编码为utf-8
//         response.setContentType("application/json;charset=utf-8");
//         // 判断对象是否是映射到一个方法，如果不是则直接通过
//         if (!(handler instanceof HandlerMethod)) {
//             // instanceof运算符是用来在运行时指出对象是否是特定类的一个实例
//             return true;
//         }
//         HandlerMethod handlerMethod = (HandlerMethod) handler;

//         Method method = handlerMethod.getMethod();

//         // 检查方法是否有PassLogin注解，有则跳过认证
//         if (method.isAnnotationPresent(PassLogin.class)) {
//             return true;
//         }

//         // 从HTTP请求头中获取Authorization信息，
//         // String authorization = request.getHeader(TokenService.getHeader());
//         // 判断Authorization是否为空
//         // if (StringUtils.isEmpty(authorization)) {
//         //     response.getWriter().write(objectMapper.writeValueAsString(Response.error("未经认证")));
//         //     return false;
//         // }
//         // 获取TOKEN,注意要清除前缀"Bearer "
//         // String token = authorization;
//         // // HTTP请求头中TOKEN解析出的用户信息
//         // Claims claims = TokenService.parseToken(token);
//         // if (claims == null) {
//         //     response.getWriter().write(objectMapper.writeValueAsString(Response.error("token无效")));
//         //     return false;
//         // }
//         // // 校验是否过期
//         // boolean flag = TokenService.isExpired(claims.getExpiration());
//         // if (flag) {
//         //     response.getWriter().write(objectMapper.writeValueAsString(Response.error("token过期")));
//         //     return false;
//         // }
//         // // token正常，获取用户信息，比如这里的subject存的是用户id
//         // String subject = claims.getSubject();
//         // // 将用户信息存入request，以便后面处理请求使用
//         // request.setAttribute("subject", subject);
//         return false;
//     }

//     @Override
//     public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//             ModelAndView modelAndView) throws Exception {

//     }

//     @Override
//     public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//             throws Exception {

//     }

}