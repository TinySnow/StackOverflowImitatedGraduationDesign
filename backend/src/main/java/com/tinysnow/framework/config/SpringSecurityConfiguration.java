package com.tinysnow.framework.config;

import java.util.List;

import com.tinysnow.framework.security.filter.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.tinysnow.framework.security.handler.AuthenticationEntryPointHandler;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration {
    /**
     * 认证失败处理类
     */
    @Autowired
    private AuthenticationEntryPointHandler unauthorizedHandler;
    /**
     * token认证过滤器
     */
    @Autowired
    private JwtAuthenticationFilter authenticationTokenFilter;

    /**
     * 跨域过滤器
     */
//    @Autowired
//    private CorsFilter corsFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors().and()
                // CSRF禁用，因为不使用session
                .csrf().disable()
                // 禁用HTTP响应标头
                .headers().cacheControl().disable().and()
                // 认证失败处理类
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                // 基于 token，所以不需要 session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // 过滤请求
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.OPTIONS, "**").permitAll()
                // 对于登录 login、注册 register、验证码 captchaImage（还未实现），测试资源，允许匿名访问
                .antMatchers("/login/**", "/register", "/captchaImage").permitAll()
                .antMatchers("/test/**").permitAll()
                .antMatchers("/user/all/*", "/tag/tags/*","/user/pass/**",
                        "/question/pass/**", "/best-answer/pass/**", "/comment/pass/**").permitAll()
                // 静态资源，可匿名访问
                .antMatchers(HttpMethod.GET, "/", "/*.html", "/**/*.html", "/**/*.css", "/**/*.js", "/profile/**")
                .permitAll()
                .antMatchers("/swagger-ui/**", "/swagger-resources/**", "/swagger/**", "/webjars/**", "/v3/**",
                        "/druid/**")
                .permitAll()
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated()
                .and()
                .headers().frameOptions().disable();
        http.addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        // 添加 CORS filter
//        http.addFilterBefore(corsFilter, JwtAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(List.of("*"));
        configuration.setAllowedHeaders(List.of("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
