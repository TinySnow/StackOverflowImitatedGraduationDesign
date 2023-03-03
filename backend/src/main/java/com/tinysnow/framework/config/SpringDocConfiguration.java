// TODO：解决 Swagger UI 不显示的问题
package com.tinysnow.framework.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("报错查助系统后端接口文档")
                        .description("南国微雪 Miyuki 的毕业设计后端接口文档")
                        .version("v0.0.1")
                        .license(new License().name("MIT License")));
    }
}
