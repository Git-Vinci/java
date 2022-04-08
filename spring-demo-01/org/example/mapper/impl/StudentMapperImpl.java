package org.example.mapper.impl;

import org.example.entity.Student;
import org.example.mapper.StudentMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentMapperImpl implements StudentMapper {

    List<Student> students =null;

   // @PostConstruct
    public void init(){
        students= new ArrayList<>();
        students.add(new Student(1,"叶涛"));
        students.add(new Student(2,"叶涛2"));
        students.add(new Student(3,"叶涛3"));
        students.add(new Student(4,"叶涛4"));
        students.add(new Student(5,"叶涛4"));
    }

    @Override
    public List<Student> findList() {
        init();
        return students;
    }
}
