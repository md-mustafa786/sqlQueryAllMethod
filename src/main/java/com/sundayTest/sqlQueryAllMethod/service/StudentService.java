package com.sundayTest.sqlQueryAllMethod.service;

import com.sundayTest.sqlQueryAllMethod.dao.StudentRepo;
import com.sundayTest.sqlQueryAllMethod.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;


    public void add(Student student) {
        studentRepo.save(student);
    }

    public List<Student> findAllStudentByfirstName(String firstName) {
        return this.studentRepo.findByFirstName(firstName);
    }

    public List<Student> findbyfirstAndLastName(String firstName, String lastName) {
        return this.studentRepo.findByFirstNameAndLastName(firstName,lastName);
    }

    public List<Student> findByLike(String firstName) {
        return this.studentRepo.findStudentByFirstNameStartingWith(firstName);
    }

    public List<Student> findByActive(boolean active) {
        return this.studentRepo.findByActive(active);
    }
}
