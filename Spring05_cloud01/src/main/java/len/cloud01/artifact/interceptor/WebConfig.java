package len.cloud01.artifact.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration  // ← 让MVC识别WebConfig为配置类
public class WebConfig implements WebMvcConfigurer {
    // WebMvcConfigurer中写了很多web相关的配置

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**")  // 拦截/admin/**的所有网页
                .excludePathPatterns("/admin")  // 排除拦截网页/admin
                .excludePathPatterns("/admin/login");  // 排除拦截网页/admin/login
    }
}
