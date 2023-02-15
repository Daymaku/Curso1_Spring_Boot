package com.example.Curso1_Spring_Boot.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.Period;

@Document(collection = "Student")
@Data
@NoArgsConstructor
//@AllArgsConstructor
public class Student {
    private long id;
    private String name;
    private String email;
    private LocalDate dob;

    @Transient
    private Integer age;



    public Student(long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }


    public Integer getAge() {
       return Period.between(this.dob,LocalDate.now()).getYears();
    }
}
