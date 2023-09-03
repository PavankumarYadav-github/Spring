package com.jspider.springcorexml.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jspider.springcorexml.bean.AnnoCompany;

public class AnnoCompanyMain {
	
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(AnnoCompanyConfig.class);
		AnnoCompany annoCompany=context.getBean(AnnoCompany.class);
		System.out.println(annoCompany);
	}

}
