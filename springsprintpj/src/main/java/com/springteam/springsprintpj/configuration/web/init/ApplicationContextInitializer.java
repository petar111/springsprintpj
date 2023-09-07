package com.springteam.springsprintpj.configuration.web.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.springteam.springsprintpj.configuration.ApplicationConfiguration;
import com.springteam.springsprintpj.configuration.web.WebApplicationConfiguration;

public class ApplicationContextInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { ApplicationConfiguration.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebApplicationConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
//		servletContext.setInitParameter(DEFAULT_SERVLET_NAME, DEFAULT_SERVLET_NAME);
	}

}
