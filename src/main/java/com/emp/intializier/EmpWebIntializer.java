package com.emp.intializier;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.emp.comfig.EmpConfig;

public class EmpWebIntializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext context) throws ServletException {

		AnnotationConfigWebApplicationContext anContext = new AnnotationConfigWebApplicationContext();
		anContext.register(EmpConfig.class);
		anContext.setServletContext(context);

		ServletRegistration.Dynamic dispatcher = context.addServlet("dispatcher", new DispatcherServlet(anContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");

		MultipartConfigElement multipartConfigElement = new MultipartConfigElement("C:/Users/somadev mishra/Documents/testUpload");
		dispatcher.setMultipartConfig(multipartConfigElement);
	}

}
