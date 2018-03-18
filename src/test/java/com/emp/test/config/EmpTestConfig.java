package com.emp.test.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.web.WebAppConfiguration;

import liquibase.integration.spring.SpringLiquibase;

@Configuration
@ComponentScan(basePackages="com.emp", excludeFilters = { 
	    @Filter(type = FilterType.ANNOTATION, value = Configuration.class)
	  })
@WebAppConfiguration
@PropertySource(value="classpath:inMemoryDB.properties")
public class EmpTestConfig {

	@Value("${jdbc.driverClassName}")
    private String jdbcDriver;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.username}")
    private String userName;

    @Value("${jdbc.password}")
    private String password;
    
   
	@Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(jdbcDriver);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource;
    }
	
	@Bean
	public JdbcTemplate jdbcTemplate(){
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public NamedParameterJdbcTemplate namedJdbcTemplate(){
		return new NamedParameterJdbcTemplate(dataSource());
	}
	
	@Bean
	public SpringLiquibase liquibase(){
		SpringLiquibase liquibase = new SpringLiquibase();
	    liquibase.setChangeLog("classpath:liquibase.xml");
	    liquibase.setDataSource(dataSource());
	    return liquibase;
	}

}
