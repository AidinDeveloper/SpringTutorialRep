package com.javatpoint;

import org.springframework.context.annotation.*;
//import org.springframework.security.config.annotation.authentication.builders.*;  
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
@ComponentScan("com.javatpoint")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withDefaultPasswordEncoder().username("Aidin").password("1234").roles("ADMIN").build());
		manager.createUser(User.withDefaultPasswordEncoder().username("MS").password("P").roles("ADMIN").build());
		return manager;
	}

	//in antMatchers you receive the request URL from the browser. 
	//in Controller you send the view Page to the client.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/index", "/user", "/").permitAll().antMatchers("/admin").authenticated()
				.and().formLogin().loginPage("/login").and().rememberMe().key("rem-me-key")
				.rememberMeParameter("remember") // it is name of checkbox at login page
				.rememberMeCookieName("rememberloginCookieName") // it is name of the cookie
				.tokenValiditySeconds(60) // remember for number of seconds
				.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
}