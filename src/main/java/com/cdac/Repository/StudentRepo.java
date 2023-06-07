package com.cdac.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.Model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

	@Modifying
	@Transactional
	@Query(value = "Truncate table Student", nativeQuery = true)
	void deleteAllData();
	
	@Query("From Student s Where s.studentPrn = ?1 and s.password = ?2")
	Student login(String studentPrn,String password);
}
