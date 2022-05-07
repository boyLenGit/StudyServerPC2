package com.len.library.library01.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/")
                // swagger的路径
                .addResourceLocations("classpath:/META-INF/resources/")
                // 用户文件的路径
                .addResourceLocations("file:/Users/mabolun/Project/Java/library01/data/");
    }
}
