package com.jspider.springcorexml.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspider.springcorexml.bean.StudentBean;

public class StudentMain {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("StudentConfig.xml");
		
		//we can use this if there is only one bean in xml
		//StudentBean studentbean=context.getBean(StudentBean.class);
		
		//we can use this if there are multiple bean
		StudentBean student1=(StudentBean)context.getBean("Student1");
		StudentBean student2=(StudentBean)context.getBean("Student2");
		StudentBean student3=(StudentBean)context.getBean("Student3");
		System.out.println(student1);
		System.out.println(student2);
		System.out.println(student3);
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
