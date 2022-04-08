package cn.steven.springsecuritydemo189.service.impl;

import cn.steven.springsecuritydemo189.entity.Student;
import cn.steven.springsecuritydemo189.mapper.StudentMapper;
import cn.steven.springsecuritydemo189.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper ;
    @Override
    public List<Student> queryList() {
        return studentMapper.queryList();
    }
}
