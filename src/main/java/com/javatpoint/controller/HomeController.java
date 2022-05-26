package com.javatpoint.controller;

import java.util.Collection;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user() {
		return "admin";
	}

	//Aidin: I have Printed user roles here!
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin() {
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for (SimpleGrantedAuthority simpleGrantedAuthority : authorities) 
			System.out.println("User Role: "+simpleGrantedAuthority );
		return "admin";
	}

	// Only, a person having ADMIN role can access this method.
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String update() {
		System.out.println("record updated");
		return "record updated ";
	}
}