package com.ssafit.movie.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	}
	
//	@Autowired
//	AdminPageInterceptor adminPageInterceptor;
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(adminPageInterceptor).addPathPatterns("/users");
//	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
<<<<<<< HEAD
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET","POST");
=======
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET","POST","PUT","DELETE");
>>>>>>> 2078337045da9b10a8f2f364d482708bbb0f86ec
	}
}