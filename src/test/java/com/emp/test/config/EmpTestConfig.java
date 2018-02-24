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

import liquibase.Liquibase;
import liquibase.integration.spring.SpringLiquibase;
import liquibase.resource.ResourceAccessor;

@Configuration
@ComponentScan(basePackages="com.emp", excludeFilters = { 
	    @Filter(type = FilterType.ANNOTATION, value = Configuration.class)
	  })
@WebAppConfiguration
@PropertySource(value="classpath:inMemoryDB.properties", name="h2DBproperties")
public class EmpTestConfig {

	@Value("${jdbc.driver}")
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
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
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
