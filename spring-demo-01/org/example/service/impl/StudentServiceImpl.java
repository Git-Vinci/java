package org.example.service.impl;

import org.example.entity.Student;
import org.example.mapper.StudentMapper;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl  implements StudentService {

    @Autowired //自动注入
    @Qualifier("studentMapperImpl2") //按照名字注入,要和上面的注解配套使用
    StudentMapper studentMapper;

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public List<Student> findList() {
        return studentMapper.findList();
    }
}
