package com.spring.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class InitConfiguration extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("config application context");
		return new Class<?> []{RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("config web context");
		return new Class<?> []{WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
	
	
	@Override
	protected Filter[] getServletFilters() {
		return new Filter[]{new CharacterEncodingFilter("utf-8")};
	}

}
