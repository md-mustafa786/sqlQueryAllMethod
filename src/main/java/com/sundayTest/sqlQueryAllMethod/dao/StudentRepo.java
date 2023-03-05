package com.sundayTest.sqlQueryAllMethod.dao;

import com.sundayTest.sqlQueryAllMethod.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

import static org.hibernate.loader.Loader.SELECT;

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

  @Modifying
  @Transactional
  @Query(value = "Update student_tbl set first_name =:firstName where id=:Id",countQuery = "SELECT count(*) FROM student_table",nativeQuery = true)
  void updateFirstName(Integer Id,String firstName);

  @Modifying
  @Transactional
  @Query(value = "Update student_tbl set first_name =:firstName,last_name = :lastName where id=:Id",countQuery = "SELECT count(*) FROM student_table",nativeQuery = true)
  void updateFirstNameAndLastName(Integer Id,String firstName,String lastName);


  @Modifying
  @Transactional
  @Query(value = "Delete from student_tbl where first_name=:firstName",countQuery = "SELECT count(*) FROM student_table",nativeQuery = true)
  void deleteFirstName(String firstName);


  List<Student> findByCreatedDate(Timestamp date);

}
