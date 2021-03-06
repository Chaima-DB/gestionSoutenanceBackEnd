package com.zsmart.gestionDesSoutenances.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http.csrf().disable();
		// http.formLogin();// in case of spring security guard this : enable login form
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.cors()
		.and()
        .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint);
		http.addFilter(new JwtAuthentificationFilter(authenticationManager()))
		.authorizeRequests().antMatchers("/authenticate", "/signin").permitAll()
		.antMatchers("/public").authenticated()
		.and()
		.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint);	
		http.addFilter(new JwtAuthentificationFilter(authenticationManager()))
		.addFilterBefore(new JwtAutorisationFilter(), UsernamePasswordAuthenticationFilter.class);
//		.and()
//		.addFilter(new );

	}

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
