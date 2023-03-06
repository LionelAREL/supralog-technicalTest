package com.supralog.supralogproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer{
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new TimeProcessLogger()).addPathPatterns("/api/v1/*");
  }
}