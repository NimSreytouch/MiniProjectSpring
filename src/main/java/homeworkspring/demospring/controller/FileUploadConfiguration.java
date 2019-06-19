package homeworkspring.demospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class FileUploadConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/storage/**").addResourceLocations("file:src/main/resources/static/storage/");
        registry.addResourceHandler("/icons/**").addResourceLocations("file:src/main/resources/static/icons/");
    }
}
