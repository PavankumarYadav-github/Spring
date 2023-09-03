package springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springrest.pojo.StudentPOJO;
import springrest.response.StudentResponse;
import springrest.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;

	@PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponse> addStudent(@RequestBody StudentPOJO pojo) {

		StudentPOJO student = service.addStudent(pojo);
		StudentResponse response=new StudentResponse();
		//Success flow
		if (student != null) {
			response.setMessage("Data Inserted Successfully");
			response.setData(student);
			return new ResponseEntity<StudentResponse>(response,HttpStatus.ACCEPTED);

		}
		//Failure flow
		response.setMessage("Data Not Inserted");
		return new ResponseEntity<StudentResponse>(response, HttpStatus.BAD_REQUEST);

	}
	@PostMapping(path = "/search{id}", produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponse> searchStudent(@PathVariable int id){
		StudentPOJO student=service.searchStudent(id);
		StudentResponse response=new StudentResponse();
		if(student!=null) {
			response.setMessage("Data Found");
			response.setData(student);
			return new ResponseEntity<StudentResponse>(response,HttpStatus.FOUND);
		}
		response.setMessage("Data Not Found");
		return new ResponseEntity<StudentResponse>(response,HttpStatus.NOT_FOUND);
		
	}
	

}
