package com.savecreator.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
@ComponentScan(basePackages = {"com.savecreator.web.controller"})
public class ServletContextConfig implements WebMvcConfigurer {
	
	@Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setOrder(2);
        return resolver;
    }   
	 @Bean
     public TilesConfigurer tilesConfigurer() {
         TilesConfigurer tilesConfigurer = new TilesConfigurer();
          tilesConfigurer.setDefinitions("/WEB-INF/tiles.xml");
         return tilesConfigurer;
     }
     @Bean
     public UrlBasedViewResolver urlBasedViewResolver() {
         UrlBasedViewResolver resolver = new UrlBasedViewResolver();
         resolver.setViewClass(TilesView.class);
         resolver.setOrder(1);
         return resolver;
     }
     @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    	 registry.addViewController("/").setViewName("index");
    }
     @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	// TODO Auto-generated method stub
    	 registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
}
