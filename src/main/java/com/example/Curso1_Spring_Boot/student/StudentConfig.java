package com.example.Curso1_Spring_Boot.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {

        return args -> {
            Student Richar = new  Student(
                    18,
                    "Richar2",
                    "Daymaku90@gmail.com",
                    LocalDate.of(1990, Month.APRIL, 4)
            );
            Student Geirelys = new  Student(
                    15,
                    "Geirelis",
                    "geirelys90@gmail.com",
                    LocalDate.of(1990, Month.JUNE, 20)
            );

            studentRepository.saveAll(List.of(Richar,Geirelys));
        };
    }

}
