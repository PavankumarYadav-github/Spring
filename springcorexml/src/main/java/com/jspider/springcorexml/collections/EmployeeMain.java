package com.jspider.springcorexml.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeMain {
	
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/jspider/springcorexml/collections/CollectionConfig.xml");
		Employee employee1=(Employee)context.getBean("employee1");
		System.err.println(employee1);
		((ClassPathXmlApplicationContext)context).close();
		
	}

}
