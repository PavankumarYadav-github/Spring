package com.jspider.springreleations.onetoonemain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspider.springreleations.onetoonebean.AadharBean;
import com.jspider.springreleations.onetoonebean.PersonBean;

public class P_A_OnetoOne {
	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("PersonConfig.xml");
		PersonBean bean1=(PersonBean)context.getBean("person1");
		System.out.println(bean1);
		ApplicationContext context1=new ClassPathXmlApplicationContext("AadharConfig.xml");
		AadharBean abean1=(AadharBean)context1.getBean("aadhar1");
		System.out.println(abean1);
		
	}

}
