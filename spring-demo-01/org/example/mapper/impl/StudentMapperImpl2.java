package org.example.mapper.impl;

import org.example.entity.Student;
import org.example.mapper.StudentMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentMapperImpl2 implements StudentMapper {

    List<Student> students =null;

   // @PostConstruct
    public void init(){
        students= new ArrayList<>();
        students.add(new Student(2,"吴长城"));
        students.add(new Student(2,"吴长城"));
        students.add(new Student(2,"吴长城"));
        students.add(new Student(2,"吴长城"));
        students.add(new Student(2,"吴长城"));
    }

    @Override
    public List<Student> findList() {
        init();
        return students;
    }
}
