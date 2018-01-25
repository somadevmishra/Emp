package com.emp.intializier;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import com.emp.comfig.WebSecurityConfig;

public class WebSecurityIntializer extends AbstractSecurityWebApplicationInitializer {

	public WebSecurityIntializer() {
		super(WebSecurityConfig.class);
	}
}
