package com.sundayTest.sqlQueryAllMethod.dao;

import com.sundayTest.sqlQueryAllMethod.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student,Integer> {


//  List<Student> findByFirstName(String firstName);

 // List<Student> findByFirstNameAndLastName(String firstName,String lastName);

//  List<Student> findByFirstNameLike(String firstName);

 // List<Student> findByActive(boolean active);

  @Query(value = "select * from student_tbl where first_name=:firstName",nativeQuery = true)
  List<Student> findByFirstName(String firstName);

  @Query(value = "select * from student_tbl where first_name=:firstName And last_name=:lastName",nativeQuery = true)
  List<Student> findByFirstNameAndLastName(String firstName,String lastName);

  @Query(value = "select * from student_tbl where first_name like =:firstName%",nativeQuery = true)
  List<Student> findStudentByFirstNameStartingWith(String firstName);

  @Query(value = "select * from student_tbl where active=:active",nativeQuery = true)
  List<Student> findByActive(boolean active);


}
