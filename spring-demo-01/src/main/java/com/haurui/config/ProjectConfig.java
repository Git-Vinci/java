package com.haurui.config;

import com.haurui.entity.School;
import com.haurui.entity.Student;
import com.haurui.entity.Teacher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration //我是一个配置类
@ImportResource("classpath:spring-context.xml")
public class ProjectConfig {

    @Bean("school_test")
    public School getSchool(Student student ,Teacher teacher){
        School school = new School();
        school.setStudent(student);
        school.setTeacher(teacher);
        return school;
    }



}
