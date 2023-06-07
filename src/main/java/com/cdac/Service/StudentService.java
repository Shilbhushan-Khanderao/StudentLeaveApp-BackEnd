package com.cdac.Service;

import java.util.List;

import com.cdac.Model.Student;

public interface StudentService {
	
	public Student userLogin(Student student);
	public Student getStudent(int studentid); 
	public boolean addStudent(Student student);
	public boolean updateStudent(Student student); 
	public boolean deleteStudent(Integer id); 	
	public List<Student> getAllStudents();
	public boolean delAllStudent(); 
}
