package com.jspider.springreleations.onetoonebean;

import lombok.Data;

@Data
public class AadharBean {
	
	int id;
	long aadhar_no;
	String date_of_issue;
	PersonBean person;
	

}
