package org.example.test;

import jdk.nashorn.internal.ir.CallNode;
import org.example.config.SpringConfig;
import org.example.entity.Student;
import org.example.web.StudentController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {

      //  ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        StudentController studentController = context.getBean(StudentController.class);
        List<Student> students = studentController.queryList();
        System.out.println(students);

    }
}


