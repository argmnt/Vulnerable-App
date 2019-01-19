package com.agh.vulnerable.vulnerableapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created on January, 2019
 *
 * @author yagiz
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private final String[] allowedUrls = {"/h2-console/**"};

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf()
					.ignoringAntMatchers("/h2-console/**")
				.and()
				.headers().frameOptions().sameOrigin()
				.and()
					.authorizeRequests()
					.antMatchers(HttpMethod.GET, allowedUrls).permitAll()
					.antMatchers(HttpMethod.POST, allowedUrls).permitAll()
					.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login").defaultSuccessUrl("/")
				.permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.inMemoryAuthentication()
				.withUser("customer1").password("{noop}password").roles("USER");
	}

}
