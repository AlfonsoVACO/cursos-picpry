package com.codehard.miscursos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.codehard.miscursos.sesion.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/", "/login", "/logout","/alumno/**").permitAll();
		http.authorizeRequests().antMatchers("/generales/**","/administrador/**","/profesor/**","/register/add").permitAll();
		http.authorizeRequests().antMatchers("/profes/**").access("hasAnyRole('ROLE_ROOT', 'ROLE_PROFE')");
		http.authorizeRequests().antMatchers("/admin/**").access("hasAnyRole('ROLE_ROOT', 'ROLE_ADMIN')");
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/access-denied");
		http.authorizeRequests().and().formLogin().loginProcessingUrl("/inlogin")
		.loginPage("/login").defaultSuccessUrl("/")
		.failureUrl("/login?error=true")//
		.usernameParameter("stremail").passwordParameter("strpass")
		.and().logout().logoutUrl("/logout").logoutSuccessUrl("/");

	}
}
