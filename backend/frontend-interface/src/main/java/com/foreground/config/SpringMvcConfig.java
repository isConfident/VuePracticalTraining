package com.foreground.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"com.foreground.controller","com.foreground.config"})
@EnableWebMvc
public class SpringMvcConfig {
}
