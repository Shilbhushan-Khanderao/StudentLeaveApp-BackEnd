package com.cdac.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.Model.Student;
import com.cdac.Service.StudentService;
import com.cdac.response.Response;

@RestController
@CrossOrigin("*")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	//http://localhost:8080/login
	@PostMapping(value = "/login")
	public ResponseEntity<?> userLogin(@RequestBody Student student) {
		Student s = studentService.userLogin(student);
		if(s == null) {
			return Response.error("User not found");
		}
		return Response.success(s);
	}
	
	//http://localhost:8080/getStudent/1
	@GetMapping(value= "/getstudent/{studentid}")
	public ResponseEntity<?> getStudent(@PathVariable("studentid") int studentid) {
		 try {
		      Student student = studentService.getStudent(studentid);

		      if (student == null) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(student, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}	
	//http://localhost:8080/students
	@GetMapping(value= "/students")
	  public ResponseEntity<List<Student>> getAllStudents() {
	    try {
	      List<Student> students = studentService.getAllStudents();

	      if (students.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(students, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	//http://localhost:8080/addStudent
	@PostMapping(value = "/addStudent")
	public ResponseEntity<?> addStudent(@RequestBody Student student){
		if(studentService.addStudent(student)) {
			return Response.success(student);
		}
		return Response.error("User addition failed");
	}
	
	//http://localhost:8080/updateStudent
	@PutMapping(value = "/updateStudent")
	public ResponseEntity<?> updateStudent(@RequestBody Student student){
		if(studentService.updateStudent(student)) {
			return Response.success(student);
        }
		return Response.error("Updation Failed");
	}
	
	//http://localhost:8080/deleteStudent?studentid=1
	@DeleteMapping(value="/deleteStudent")
	public ResponseEntity<Map<String,String>> deleteStudent(@RequestParam("studentid") Integer id){
		HashMap<String, String> hmap = new HashMap<>();
		
		if(studentService.deleteStudent(id))
			hmap.put("msg", "Deleted");
		else
			hmap.put("msg", "Failed");
		
		return ResponseEntity.ok(hmap);
	}
	
	//http://localhost:8080/deleteallstudent
	@DeleteMapping(value = "/deleteallstudents")
	public ResponseEntity<?> deleteAllStudents(){
			if(studentService.delAllStudent()) {
				return ResponseEntity.status(HttpStatus.OK).body("Student Data Deleted Successfully.");
			}
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Student Data Deletion Failed.");
	}
}
