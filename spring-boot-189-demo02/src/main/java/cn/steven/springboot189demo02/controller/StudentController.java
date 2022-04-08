package cn.steven.springboot189demo02.controller;

import cn.steven.springboot189demo02.entity.Student;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @RequestMapping("/t2")
    //                这个注解一定要加
    public String t2(@Validated      /* @RequestBody*/ Student student){
        System.out.println(student);
        return "success" ;
    }
}
