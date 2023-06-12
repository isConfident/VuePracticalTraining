package com.foreground.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class MultipartConfig {
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(10485760); // 设置最大上传文件大小为10MB
        resolver.setDefaultEncoding("UTF-8"); // 设置默认编码格式为UTF-8
        return resolver;
    }
}
