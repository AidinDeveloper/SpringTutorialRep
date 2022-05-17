package com.javatpoint;

import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController2 {
	@RequestMapping("/hello2")
	public String redirect() {
		System.out.println(SpringVersion.getVersion());
		return "viewpage2";
	}
}