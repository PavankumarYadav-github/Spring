package com.jspider.springmvc.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.springmvc.pojo.AdminPOJO;
import com.jspider.springmvc.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	private AdminRepository repository;
	
	
	
	public List<AdminPOJO> getAdmin() {
		List<AdminPOJO> admin = repository.getAdmin();
		return admin;
	}
	
	public AdminPOJO addAdmin(String username,String password) {
		AdminPOJO adminPOJO=repository.addAdmin(username,password);
		return adminPOJO;
	}
	public AdminPOJO login(String usename,String password) {
		AdminPOJO adminPOJO=repository.login(usename,password);
		return adminPOJO;
	}

}
