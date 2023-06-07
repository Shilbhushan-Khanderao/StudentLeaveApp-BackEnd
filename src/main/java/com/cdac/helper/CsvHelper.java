package com.cdac.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.cdac.Model.Student;

public class CsvHelper {
	public static String TYPE = "text/csv";
	static String[] Headers = {"StudentPrn","StudenName","MobileNumber","Email","Password"};
	
	public static boolean hasCSVFormat(MultipartFile file) {

	    if (!TYPE.equals(file.getContentType())) {
	      return false;
	    }

	    return true;
	  }
	
	@SuppressWarnings("deprecation")
	public static List<Student> csvToStudents(InputStream is) {
	    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        CSVParser csvParser = new CSVParser(fileReader,
	            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

	      List<Student> students = new ArrayList<>();

	      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

	      for (CSVRecord csvRecord : csvRecords) {
	        Student student = new Student(
	              csvRecord.get("StudentPrn"),
	              csvRecord.get("StudentName"),
	              csvRecord.get("MobileNumber"),
	              csvRecord.get("Email"),
	              csvRecord.get("Password")
	            );

	        students.add(student);
	      }

	      return students;
	    } catch (IOException e) {
	      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
	    }
	  }
}
