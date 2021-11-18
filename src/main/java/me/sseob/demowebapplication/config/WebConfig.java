package me.sseob.demowebapplication.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/m/**")
				.addResourceLocations("classpath:/m/")
				.setCachePeriod(10);
	}

	/*
		좀 더 Global하게 Cross origin mapping을 허용하려면, 
		@CorsOrigin annotation을 마구마구 쓰는 대신에 기능을 확장하여 간단하게 설정하자 ㅎㅎㅎ
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("http://localhost:18080");
	}
}
