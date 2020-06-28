package com.mufg.coordinateprocessor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.mufg.coordinateprocessor.util.CoordinateConstants;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * In memory Credentials for Authentication and Roles
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser(CoordinateConstants.USER_NAME).password("{noop}password")
				.roles(CoordinateConstants.USER_ROLE).and().withUser(CoordinateConstants.ADMIN_IDENTIFIER)
				.password("{noop}password").roles(CoordinateConstants.USER_ROLE, CoordinateConstants.ADMIN_ROLE);

	}

	// Secure the endpoins with HTTP Basic authentication
	/**
	 * Filters and authenticates the incoming requests
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
				// HTTP Basic authentication
				.httpBasic().and().authorizeRequests()
				.antMatchers(HttpMethod.GET, CoordinateConstants.COORDINATE_URI_MAPPER + "/**")
				.hasRole(CoordinateConstants.USER_ROLE)
				.antMatchers(HttpMethod.POST, CoordinateConstants.COORDINATE_URI_MAPPER + "/**")
				.hasRole(CoordinateConstants.ADMIN_ROLE)
				.antMatchers(HttpMethod.PUT, CoordinateConstants.COORDINATE_URI_MAPPER + "/**")
				.hasRole(CoordinateConstants.ADMIN_ROLE)
				.antMatchers(HttpMethod.PATCH, CoordinateConstants.COORDINATE_URI_MAPPER + "/**")
				.hasRole(CoordinateConstants.ADMIN_ROLE)
				.antMatchers(HttpMethod.DELETE, CoordinateConstants.COORDINATE_URI_MAPPER + "/**")
				.hasRole(CoordinateConstants.ADMIN_ROLE).and().csrf().disable().formLogin().disable();
	}

}