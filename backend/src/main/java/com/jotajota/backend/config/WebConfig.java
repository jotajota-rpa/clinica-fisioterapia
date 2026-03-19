package com.jotajota.backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${ruta.storage.root}")
    private String rootPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String base = "file:///" + rootPath.replace("\\", "/");
        if (!base.endsWith("/")) base += "/";

        registry.addResourceHandler("/logos/**")
                .addResourceLocations(base + "ajustes/imagenes/");
    }
}
