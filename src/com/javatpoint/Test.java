package com.javatpoint;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test {

	public static void main(String[] args) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		EmployeeDao dao = (EmployeeDao) factory.getBean("edao");
		Object o=dao.save(new Employee(2223, "sonoo", 50000));
		System.out.println("Done");
	}
}
