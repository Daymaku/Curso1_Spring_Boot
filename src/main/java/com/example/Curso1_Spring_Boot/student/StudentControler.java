package com.example.Curso1_Spring_Boot.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/Student")
public class StudentControler {


//    private final StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

//    @Autowired
//    public StudentControler(StudentService studentService) {
//        this.studentService = studentService;
//    }

    @GetMapping
    public List<Student> getStudents() {
        return  studentRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> saveStudent(@RequestBody Student student){
        try {
           List<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
            Student studentsave = studentRepository.save(student);
            return new ResponseEntity<Student>(studentsave, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "{studentId}")
    public void  deleteStudent(
            @PathVariable("studentId") Long studentId){
       boolean exists = studentRepository.existsById(studentId);
    if (!exists){
        throw new IllegalStateException("No existe el elemento" + studentId.toString());
    }
        studentRepository.deleteById(studentId);
    }



//    @PostMapping
//    public ResponseEntity<?> deleteStudent(@RequestBody long id ){
//        try {
//            studentRepository.deleteById(id);
//            return '';
//        } catch (Exception e){
//            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }



}
