package com.jspider.springcorexml.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspider.springcorexml.bean.PersonBean;

public class PersonMain {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("PersonConfig.xml");
		PersonBean bean1 =(PersonBean)context.getBean("person1");
		PersonBean bean2 =(PersonBean)context.getBean("person2");
		System.out.println(bean1);
		System.out.println(bean2);
		((ClassPathXmlApplicationContext)context).close();
	}

}
