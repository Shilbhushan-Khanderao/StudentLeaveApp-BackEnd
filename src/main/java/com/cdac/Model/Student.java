package com.cdac.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private int studentId;
	@Column(name = "student_prn", unique = true)
	private String studentPrn;
	@Column(name = "student_name")
	private String studentName;
	@Column(name = "mobile_number")
	private String mobileNumber;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String studentPrn, String studentName, String mobileNumber, String email,
			String password) {
		this.studentPrn = studentPrn;
		this.studentName = studentName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentPrn() {
		return studentPrn;
	}

	public void setStudentPrn(String studentPrn) {
		this.studentPrn = studentPrn;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentPrn=" + studentPrn + ", studentName=" + studentName
				+ ", mobileNumber=" + mobileNumber + ", email=" + email + ", password=" + password + "]";
	}
	
}
