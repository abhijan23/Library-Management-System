package com.xfactor.openlibrary.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.xfactor.openlibrary.domain.Student;

public interface StudentRepositories extends JpaRepository<Student, Long>{
    List<Student> findByname(String name);
    List<Student> findBydepartment(String department);
    List<Student> findByrollNumber(String rollNumber);
    List<Student> findBybirthDate(String birthDate);
    List<Student> findBymobileNumber(String mobileNumber);
}
