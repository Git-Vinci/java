package com.haurui.config;

import com.haurui.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {


    @Bean
    public Student getStudent(){
        Student student = new Student();
        student.setName("邱莫然");
        student.setSid(1);
        return student;
    }
}
