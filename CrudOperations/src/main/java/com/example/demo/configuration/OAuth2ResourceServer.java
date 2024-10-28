package com.example.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class OAuth2ResourceServer extends ResourceServerConfigurerAdapter
{
	 @Override
	 public void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests()
	
			.antMatchers("/Employees/**").access("#oauth2.hasScope('read')")
			/*.antMatchers(HttpMethod.GET,"/Employees/FindEmployeeById{id}").hasAuthority(null)
			.antMatchers(HttpMethod.GET,"/Employees/getAllEmployees").hasAnyRole("EMPLOYEE","NON_EMPLOYEE")
			.antMatchers(HttpMethod.POST,"/Employees/CreateEmployees").hasAnyRole("EMPLOYEE")*/
			.and().headers().frameOptions().disable()
			
			.and().csrf().disable();
		
	 }
}



