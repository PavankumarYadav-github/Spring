package com.jspider.springmvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.springmvc.pojo.StudentPOJO;
import com.jspider.springmvc.repository.StudentrRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentrRepository repository;
	
	public StudentPOJO addStudent(String name,String email,long mobile,String address) {
		
		StudentPOJO pojo=repository.addStudent(name,email,mobile,address);
		return pojo;
		
	}
	public StudentPOJO searchStudent(int id) {
		
		StudentPOJO pojo = repository.serchStudent(id);
		return pojo;
	}
	public StudentPOJO removedata(int id) {
		StudentPOJO pojo=repository.removedata(id);
		return pojo;
	}
	public List<StudentPOJO> showdata() {
		List<StudentPOJO> pojo=repository.showdata();
		return pojo;
		
	}
	public StudentPOJO updatedata(int id,String name,String email,long mobile,String address) {
		StudentPOJO pojo=repository.updatedata(id,name,email,mobile,address);
		return pojo;
	}
}
