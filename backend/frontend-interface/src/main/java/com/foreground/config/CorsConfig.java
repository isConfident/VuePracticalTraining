package com.foreground.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8081") // 允许所有来源跨域访问，你可以根据需求指定具体的来源
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 允许的请求方法
                .allowedHeaders("*") // 允许的请求头
                .allowCredentials(true) // 是否允许发送Cookie
                .maxAge(3600); // 预检请求的有效期，单位为秒
    }
}
