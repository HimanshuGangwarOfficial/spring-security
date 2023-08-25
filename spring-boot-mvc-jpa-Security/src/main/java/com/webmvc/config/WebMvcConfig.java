package com.webmvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/jsp/",".jsp");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {

		registry.addViewController("/home.htm").setViewName("home");
		registry.addViewController("/login.htm").setViewName("login");
		registry.addViewController("/logout.htm").setViewName("logout");
	}
	
	
	

}
