package com.haurui.entity.test;

import com.haurui.config.ProjectConfig;
import com.haurui.entity.School;
import com.haurui.entity.Student;
import com.haurui.entity.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
      /*  ApplicationContext context
                = new ClassPathXmlApplicationContext("classpath:spring-context.xml");*/

       ApplicationContext context
               = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // System.out.println(new Student(1, "steven"));

        Object student = context.getBean(Student.class);
        System.out.println(student);

        Teacher teacher = context.getBean(Teacher.class);
        System.out.println(teacher);
       School school = context.getBean("school_test",School.class);
        System.out.println(school);
        //  System.out.println(context.getBean(Teacher.class));

/*
        Student student1 = context.getBean(Student.class);
        System.out.println(student==student1);

        Teacher teacher = context.getBean(Teacher.class);
        System.out.println(teacher);
*/

    }
}
