package com.martimlima.springcourse.securitymodule.restrictedaccessbasedonroles.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
	    	.antMatchers("/").permitAll()  // allow public access to home page
	    	.antMatchers("/employees").hasRole("EMPLOYEE")
	    	.antMatchers("/leaders/**").hasRole("MANAGER")
	    	.antMatchers("/admins/**").hasRole("ADMIN")
			.and()
			.formLogin()
			.loginPage("/showLoginPage")
			.loginProcessingUrl("/authenticateUser")
			.permitAll()
			.and()
			.logout()
			.permitAll()
			.and()
			.exceptionHandling()
			.accessDeniedPage("/access-denied");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// add our users for in memory authentication
		//@SuppressWarnings("deprecation")
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication().withUser(users.username("john")
													.password("test123")
													.roles("EMPLOYEE"));
		
		auth.inMemoryAuthentication().withUser(users.username("mary")
													.password("test123")
													.roles("EMPLOYEE", "MANAGER"));
		
		auth.inMemoryAuthentication().withUser(users.username("susan")
													.password("test123")
													.roles("EMPLOYEE", "ADMIN"));
	}
}
