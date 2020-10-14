package com.martimlima.springcourse.securitymodule.jdbc.dbauth.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.martimlima.springcourse.securitymodule.jdbc.dbauth")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
	
	// set up a variable to hold the properties
	@Autowired
	private Environment environment;
	
	// set up a logger for diagnostics
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	// define a bean for the viewResolver
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	
	// define a bean for the security data source
	@Bean
	public DataSource securityDataSource() {
		
		// create a connection pool
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		
		// set the JDBC driver class
		try {
			securityDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
			
		} catch (PropertyVetoException ex) {
			throw new RuntimeException(ex);
		}
		
		// log the connection props
		logger.info("=======> jdbc.url = " + environment.getProperty("jdbc.url"));
		logger.info("=======> jdbc.user = " + environment.getProperty("jdbc.user"));
		
		// set the database connection props
		securityDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
		securityDataSource.setUser(environment.getProperty("jdbc.user"));
		securityDataSource.setPassword(environment.getProperty("jdbc.password"));
		
		// set connection pool properties
		securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		
		
		return securityDataSource;
	}
	
	
	// helper method to read the environment property and convert it to int
	private int getIntProperty(String propName) {
		
		String propVal = environment.getProperty(propName);
		
		// now convert to int
		int intPropVal = Integer.parseInt(propVal);
		
		return intPropVal;
	}
}
