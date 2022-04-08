package org.example.web;

import org.example.entity.Student;
import org.example.service.StudentService;
import org.example.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public List<Student> queryList(){
        List<Student> students = studentService.findList();
        return  students;
    }



}
