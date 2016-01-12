package com.spring.config;


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
	

	
}
