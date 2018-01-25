package com.emp.comfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.emp")
public class EmpConfig extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver empViewResolver(){
		InternalResourceViewResolver irvr= new InternalResourceViewResolver();
		irvr.setViewClass(JstlView.class);
		irvr.setPrefix("WEB-INF/views/");
		irvr.setSuffix(".jsp");
		
		return irvr;
	}
	
}
