package com.cdac.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.Model.Student;

@Repository
public interface CsvRepo extends JpaRepository<Student, Integer> {

}
