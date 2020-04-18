package com.xdong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.xdong.interceptor.CompanyPermissionInterceptor;
import com.xdong.interceptor.IndividualPermissionInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.xdong" })
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Override
	public void addInterceptors (InterceptorRegistry registry) {
		registry.addInterceptor(new IndividualPermissionInterceptor()).addPathPatterns("/application/*", "/user/*", "/apply/*");
		registry.addInterceptor(new CompanyPermissionInterceptor())
		.addPathPatterns("/position/company/*", "/position/add", "/position/update/*", "/position/save", "/company/mine", 
				"/company/update", "/company/save", "/company/index", "/company/application/*", "/company/schedule/*", "/company/reject/");
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
	    CommonsMultipartResolver resolver=new CommonsMultipartResolver();
	    resolver.setMaxUploadSize(10000000);
	    resolver.setDefaultEncoding("utf-8");
	    return resolver;
	}
	
	
	

}