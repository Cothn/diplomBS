package org.atsynthesizer.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Value("${upload.path}")
    private  String UPLOAD_DIR;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**")
        .addResourceLocations("file:///D:/" +UPLOAD_DIR);
        registry.addResourceHandler("/download/**")
                .addResourceLocations("file:///D:/" +UPLOAD_DIR);
    }


}
