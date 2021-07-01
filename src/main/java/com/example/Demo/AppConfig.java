package com.example.Demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * @author Akash Budhwani
 *
 */
@Component
public class AppConfig implements WebMvcConfigurer  {
		@Autowired
		CustomRequestInterceptor customRequestInterceptor;

	   @Override
	   public void addInterceptors(InterceptorRegistry registry) {
	      registry.addInterceptor(customRequestInterceptor);
	   }
}
