package com.cdac.serviceImpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cdac.Model.Student;
import com.cdac.Repository.StudentRepo;
import com.cdac.Service.CsvService;
import com.cdac.helper.CsvHelper;

@Service
public class CsvServiceImpl implements CsvService {
	
	@Autowired
	StudentRepo studentRepo;
	
	public void save(MultipartFile file) {
		try {
			List<Student> students = CsvHelper.csvToStudents(file.getInputStream());
			studentRepo.saveAll(students);
		} catch (IOException e) {
			throw new RuntimeException("fail to store csv data: " + e.getMessage());	
		}
	}
}