package com.cdac.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.Model.Student;
import com.cdac.Repository.StudentRepo;
import com.cdac.Service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	public Student userLogin(Student student) {
		try {

			Student s = studentRepo.login(student.getStudentPrn(), student.getPassword());
			if( s != null) {
				if(s.getStudentPrn().equals(student.getStudentPrn()) && s.getPassword().equals(student.getPassword()))
					return s;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Student getStudent(int studentid) {
		try {
			Optional<Student> opt = studentRepo.findById(studentid);
			if(opt.isPresent()) {
				return opt.get();
			}
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean addStudent(Student student) {
		try {
			Optional<Student> opt = studentRepo.findById(student.getStudentId());
			
			if(opt.isPresent())
				return false;
			else {
				studentRepo.save(student);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateStudent(Student student) {
		try {
			Optional<Student> opt = studentRepo.findById(student.getStudentId());
			
			if(opt.isPresent()) {
				studentRepo.save(student);
				return true;
			}
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteStudent(Integer id) {
		try {
			Optional<Student> opt = studentRepo.findById(id);
			
			if(opt.isPresent()) {
				studentRepo.deleteById(id);
				return true;
			}
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}	
	
	public List<Student> getAllStudents(){
		return studentRepo.findAll();
	}
	
	public boolean delAllStudent() {
		try {
			studentRepo.deleteAllData();
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
}
