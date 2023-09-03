package com.jspider.springcorexml.main;

import org.springframework.context.annotation.Bean;

import com.jspider.springcorexml.bean.AnnoCompany;

public class AnnoCompanyConfig {
	
	@Bean()
	public AnnoCompany getbean() {	
		return new AnnoCompany();
	}
	

}
