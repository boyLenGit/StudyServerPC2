package com.len.library.library01.Config;

import com.len.library.library01.util.LenPath;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/").addResourceLocations("classpath:/templates/")
                // swagger的路径
                .addResourceLocations("classpath:/META-INF/resources/")
                // 用户文件的路径
                .addResourceLocations("file:" + LenPath.getData() + "/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Intercepter01()).addPathPatterns("/user/**")
                .excludePathPatterns("/user/sign_up").excludePathPatterns("/user/sign_up_post")
                .excludePathPatterns("/user/sign_in").excludePathPatterns("/user/sign_in_post");
    }
}
