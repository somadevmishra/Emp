package com.emp.comfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.emp.service.impl.UserServiceImpl;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Bean
	public UserDetailsService userService(){
		return new UserServiceImpl();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		
		//auth.inMemoryAuthentication().withUser("somadev").password("password").roles("USER");
		auth.userDetailsService(userService());
				
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
