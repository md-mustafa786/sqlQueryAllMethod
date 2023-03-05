package com.sundayTest.sqlQueryAllMethod.controller;

import com.sundayTest.sqlQueryAllMethod.model.Student;
import com.sundayTest.sqlQueryAllMethod.service.StudentService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("add-data")
    public ResponseEntity<String> addData(@RequestBody String studentData){
        Student student = setData(studentData);
        service.add(student);
        return new ResponseEntity<>("saved", HttpStatus.ACCEPTED);
    }

    @GetMapping("find-by-firstName")
    public List<Student> findAllStudentByfirstName(@RequestParam String firstName){
        return this.service.findAllStudentByfirstName(firstName);
    }

    @GetMapping("/find-by-first/last-name")
    public List<Student> findByFirstAndLastName(@RequestParam String firstName,String lastName){
        return this.service.findbyfirstAndLastName(firstName,lastName);
    }

    @GetMapping("/like/{firstName}")
    public List<Student> findByLike(@PathVariable String firstName){
        return this.service.findByLike(firstName);
    }

    @GetMapping("findByActive")
    public List<Student> findByActive(@RequestParam boolean active){
        return this.service.findByActive(active);
    }

    @PutMapping("updateFirstName/{Id}/{firstName}")
    public void updateFirstName(@PathVariable Integer Id, @PathVariable String firstName){
         service.updateFirstName(Id,firstName);
    }

    @PutMapping("updateFirstNameAndLastName/{Id}/{firstName}/{lastName}")
    public ResponseEntity<String> updateFirstNameAndLastName(@PathVariable Integer Id, @PathVariable String firstName, @PathVariable String lastName){
        service.updateFirstNameAndLastName(Id,firstName,lastName);
        return new ResponseEntity<>("updated",HttpStatus.OK);
    }

    @DeleteMapping("/deleteByFirstName")
    public ResponseEntity<String> deleteByFirstName(@RequestParam String firstName){
        this.service.deleteByFirstName(firstName);
        return new ResponseEntity<>("deleted",HttpStatus.OK);
    }

    @GetMapping("findByDate")
    public List<Student> findbydate(@RequestParam Timestamp date){
        return this.service.findByDate(date);
    }



    private Student setData(String studentData) {
        JSONObject jsonObject = new JSONObject(studentData);
        Student student = new Student();
        student.setId(jsonObject.getInt("Id"));
        student.setAge(jsonObject.getInt("age"));
        student.setEmail(jsonObject.getString("email"));
        student.setFirstName(jsonObject.getString("firstName"));
        student.setLastName(jsonObject.getString("lastName"));
        Timestamp createdDate = new Timestamp(System.currentTimeMillis());
        student.setCreatedDate(createdDate);
        student.setGender(jsonObject.getString("gender"));
        student.setActive(jsonObject.getBoolean("active"));
        return student;
    }
}
