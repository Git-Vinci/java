package cn.steven.springsecuritydemo189.web;

import cn.steven.springsecuritydemo189.entity.Student;
import cn.steven.springsecuritydemo189.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService ;

    @RequestMapping("/list")
    List<Student> queryList(){
        return studentService.queryList();
    }
}
