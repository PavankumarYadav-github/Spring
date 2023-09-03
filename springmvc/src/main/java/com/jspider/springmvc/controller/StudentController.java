package com.jspider.springmvc.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;


import com.jspider.springmvc.pojo.AdminPOJO;
import com.jspider.springmvc.pojo.StudentPOJO;
import com.jspider.springmvc.services.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/home")
	public String home(@SessionAttribute(name="pojo", required=false )AdminPOJO adminPOJO,ModelMap map) {
		if(adminPOJO!=null) {
			return "Home";
		}
		map.addAttribute("msg","Please Login");
		return "Login";
		
		
	}
	@GetMapping("/add")
	public String add(@SessionAttribute(name="pojo" ,required = false) AdminPOJO adminPOJO,ModelMap map) {
		
		if(adminPOJO!=null) {
			return "StudentAdd";
		}
		map.addAttribute("msg","Please Login");
		return "Login";
	}
	
	@PostMapping("/add")
	public String addStudent(@RequestParam String name,@RequestParam String email,@RequestParam long mobile,
							@RequestParam String address,
							@SessionAttribute(name = "pojo",required = false)AdminPOJO adminPOJO,ModelMap map) {
		if(adminPOJO!=null) {
			StudentPOJO pojo=service.addStudent(name, email, mobile, address);
			//Success
			if(pojo!=null) {
				map.addAttribute("msg","data inserted successfully");
				return "StudentAdd";
			}
			//Failure
			map.addAttribute("msg", "Data not inserted. ");
			return "StudentAdd";
		}
		map.addAttribute("msg","Please Login");
		return "Login";
	}
	
	@GetMapping("/search")
	public String searchPage(@SessionAttribute(name = "pojo" ,required = false)AdminPOJO adminPOJO,ModelMap map) {
		if(adminPOJO!=null) {
			return "SearchStudent";
		}
		map.addAttribute("msg","Please Login");
		return "Login";
	}
	@PostMapping("/search")
	public String searchPage(@RequestParam int id,ModelMap map,@SessionAttribute(name = "pojo" ,required = false)AdminPOJO adminPOJO) {
		if(adminPOJO!=null) {
			StudentPOJO pojo=service.searchStudent(id);
			if(pojo!=null) {
				map.addAttribute("Student", pojo);
				map.addAttribute("msg","DATA  FOUND");
				return "SearchStudent";
			}
			map.addAttribute("msg","DATA NOT FOUND");
			return "SearchStudent";
		}
		map.addAttribute("msg","Please Login");
		return "Login";
		
		
	}

	@GetMapping("/remove")
	public String removePage(ModelMap map,@SessionAttribute(name = "pojo",required = false)AdminPOJO adminPOJO){
		if(adminPOJO!=null) {
			List<StudentPOJO> pojo1=service.showdata();
			map.addAttribute("pojolist",pojo1);
			return "Remove";
		}
		map.addAttribute("msg","Please Login");
		return "Login";
	}
	@PostMapping("/remove")
	public String removedata(@RequestParam int  id,ModelMap map,@SessionAttribute(name = "pojo",required = false)AdminPOJO adminPOJO) {
		
		if(adminPOJO!=null) {
			StudentPOJO pojo=service.removedata(id);
			if(pojo!=null) {
				List<StudentPOJO> pojo1=service.showdata();
				map.addAttribute("pojolist",pojo1);
				map.addAttribute("msg","DATA REMOVED");
				return "Remove";
			}
			List<StudentPOJO> pojo1=service.showdata();
			map.addAttribute("pojolist",pojo1);
			map.addAttribute("msg","DATA NOT FOUND");
			return "Remove";
		}
		map.addAttribute("msg","Please Login");
		return "Login";
	}
	
	@GetMapping("/update")
	
	public String updatePage(ModelMap map,@SessionAttribute(name = "pojo" ,required = false)AdminPOJO adminPOJO) {
		if(adminPOJO!=null) {
			List<StudentPOJO> pojos=service.showdata();
			map.addAttribute("pojolist", pojos);
			return "UpdateStudent";
		}
		map.addAttribute("msg","Please Login");
		return "Login";
	}
	@PostMapping("/update")
	public String updateForm(@RequestParam int id,ModelMap map,@SessionAttribute(name = "pojo",required = false)AdminPOJO adminPOJO) {
		if(adminPOJO!=null) {
			StudentPOJO pojo=service.searchStudent(id);
			if(pojo!=null) {
				map.addAttribute("pojo", pojo);
				return "UpdateStudent";
			}
			map.addAttribute("msg", "Data does not exist ");
			List<StudentPOJO> pojos=service.showdata();
			map.addAttribute("pojolist", pojos);
			return "UpdateStudent";
		}
		map.addAttribute("msg","Please Login");
		return "Login";
	}
	@PostMapping("/updatedata")
	public String updatePage(@RequestParam int id,@RequestParam String name,@RequestParam String email,@RequestParam long mobile,@RequestParam String address,ModelMap map,@SessionAttribute(name = "pojo",required = false) AdminPOJO adminPOJO) {
		if(adminPOJO!=null) {
			StudentPOJO pojo=service.updatedata(id, name, email, mobile, address);
			if(pojo!=null) {
				map.addAttribute("msg", "DATA UPDATED");
				List<StudentPOJO> pojos=service.showdata();
				map.addAttribute("pojolist", pojos);
				return "UpdateStudent";
				
			}
			map.addAttribute("msg", "DATA NOT UPDATED");
			List<StudentPOJO> pojos=service.showdata();
			map.addAttribute("pojolist", pojos);
			return "UpdateStudent";

		}
		map.addAttribute("msg","Please Login");
		return "Login";
		
		
	}
	
	
	
	
	


}
