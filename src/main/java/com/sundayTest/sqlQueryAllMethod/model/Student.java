package com.sundayTest.sqlQueryAllMethod.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student_tbl")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private Integer age;
    private Timestamp createdDate;
    private boolean active;
}
