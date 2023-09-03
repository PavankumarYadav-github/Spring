package com.jspider.springcorexml.collections;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class Employee {
	
	String name;
	List<String> phones;
	Set<String> address;
	Map<String, String> coures;

}
