package com.xfactor.openlibrary.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import com.xfactor.openlibrary.domain.Student;
import com.xfactor.openlibrary.repositories.StudentRepositories;
@RestController
@RequestMapping("students")
public class StudentController {
    private StudentRepositories studentRepositories;
    public StudentController(StudentRepositories studentRepositories){
        this.studentRepositories = studentRepositories;
    }

    @PostMapping("/savestudent")
    public Student saveStudent(@RequestBody Student student)
    {
        studentRepositories.save(student);
        return student;
    }

    @PutMapping("/updateStudent")
    public Student updateStudent(@RequestBody Student student, CrudRepository<Student, Long> studentRepository) {
        if (student.getId() != null) {
            Student student2 = studentRepository.save(student);
            return student2;
        }
        return null;
    }

    @DeleteMapping("delete/{id}")
    public void deletestudent(@PathVariable Long id) {
        studentRepositories.deleteById(id);
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents()
    {
        return studentRepositories.findAll();
    }

    @GetMapping("findTotal")
    public Long findTotal() {
        return studentRepositories.count();
    }

    @GetMapping("findById/{id}")
    public Student findById(@PathVariable Long id){
        Optional<Student> optionalOfStudent = studentRepositories.findById(id);
        if(optionalOfStudent.isPresent()){
            return optionalOfStudent.get();
        }
        return null;
    }

    @GetMapping("findByname/{name}")
    public List<Student> findByname(@PathVariable String name){
        List<Student> listOfname = studentRepositories.findByname(name);
        return listOfname;
    }

    @GetMapping("findBydepartment/{department}")
    public List<Student> findBydepartment(@PathVariable String department){
        List<Student> listOfdepartment = studentRepositories.findBydepartment(department);
        return listOfdepartment;
    }

    @GetMapping("findByrollNumber/{rollNumber}")
    public List<Student> findByrollNumber(@PathVariable String rollNumber){
        List<Student> listOfrollNumber = studentRepositories.findByrollNumber(rollNumber);
        return listOfrollNumber;
    }

    @GetMapping("findBybirthDate/{birthDate}")
    public List<Student> findBybirthDate(@PathVariable String birthDate){
        List<Student> listOfbirthDate = studentRepositories.findBybirthDate(birthDate);
        return listOfbirthDate;
    }

    @GetMapping("findBymobileNumber/{mobileNumber}")
    public List<Student> findBymobileNumber(@PathVariable String mobileNumber){
        List<Student> listOfmobileNumber = studentRepositories.findBymobileNumber(mobileNumber);
        return listOfmobileNumber;
    }

}