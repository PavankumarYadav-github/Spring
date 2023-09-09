package com.jspider.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspider.springmvc.pojo.AdminPOJO;
import com.jspider.springmvc.services.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	private  AdminService service;
	
	
	@PostMapping("/login")
	public String login(@RequestParam String username,@RequestParam String password,ModelMap map,HttpSession Session) {
		AdminPOJO adminPOJO=service.login(username,password);
		if(adminPOJO!=null) {
			Session.setAttribute("pojo", adminPOJO);
			Session.setMaxInactiveInterval(30);
			return "Home";
		}
		map.addAttribute("msg","Invalid credential. try again.");
		return "Login";
		
	}
	@GetMapping("/logout")
	public String logout(ModelMap map,HttpSession session) {
		session.invalidate();
		map.addAttribute("msg","Logged out successfully");
		return "Login";
	}
	
	
	@GetMapping("/createAdmin")
	public String createPage(ModelMap map) {
		List<AdminPOJO> admins=service.getAdmin();
		if(admins!=null) {
			return "CreateAccount";
		}
		map.addAttribute("msg", "Admin account already exists.");
		return "Login";
		
	}
	
	@PostMapping("/createAdmin")
	public String createAdmin(@RequestParam String username,@RequestParam String password,ModelMap map) {
		AdminPOJO adminPOJO=service.addAdmin(username,password);
		if(adminPOJO!=null) {
			map.addAttribute("msg", "Admin Created. Login now");
			return "Login";
		}
		map.addAttribute("msg", "Failed to create account. Try again. ");
		return "CreateAccount";
	}
	
	

}
