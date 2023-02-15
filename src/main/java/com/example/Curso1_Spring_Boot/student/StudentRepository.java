package com.example.Curso1_Spring_Boot.student;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student, Long> {

   @Query("SELECT s FROM Student s WHERE s.email = 'sdfsdf''")
   List<Student> findStudentByEmail(String email);


}
