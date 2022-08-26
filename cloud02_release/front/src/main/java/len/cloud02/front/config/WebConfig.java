package len.cloud02.front.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/21 10:56
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("${boyLen_data_path}")
    private String dataPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/").addResourceLocations("classpath:/templates/")
                // swagger的路径
                .addResourceLocations("classpath:/META-INF/resources/")
                // 用户文件的路径
                .addResourceLocations("file:" + dataPath + "/");

    }
}
