package com.emp.comfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages={"com.emp"})
@PropertySource(value="classpath:project.properties", name="mysqlproperties")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	/*
	 * This is method is used for fixed username and password
	 * @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.inMemoryAuthentication().withUser("somadev").password("password").roles("USER");
				
	}*/
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
	  throws Exception {
	    //auth.authenticationProvider(authenticationProvider());
		auth.userDetailsService(userDetailsService);
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
	    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	    authProvider.setUserDetailsService(userDetailsService);
	    return authProvider;
	}
	
	/**
	 * After extending WebSecurityConfigurerAdapter. this method is used for HTTP security
	 * @param httpSecurity
	 * @throws Exception 
	 */
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.authorizeRequests()
			.antMatchers("/login").permitAll()//permission for everyone to access login page
			.antMatchers("/**").permitAll() //permission for everyone to access indexpage(welcome page)
			.and()
			.formLogin().loginPage("/login") //custom login page URL
				.usernameParameter("username") //username field
				.passwordParameter("password") //password field
			.and()
			.csrf()  
			.and()
			.logout()
				.logoutUrl("/logout")
				.invalidateHttpSession(true)
				.logoutSuccessUrl("/")
			;
		
	}
	
}
