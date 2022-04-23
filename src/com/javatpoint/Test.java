package com.javatpoint;

import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Operation op = (Operation) context.getBean("opBean");
		op.msg();
		op.display();
	}
}