package com.jspider.springcorexml.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspider.springcorexml.bean.CompanyBean;

public class CompanyBeanMain {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("CompanyBean.xml");
		CompanyBean bean=(CompanyBean)context.getBean("company1");
		System.out.println(bean);
	}

}
