package cn.steven.springboot189demo02.controller;

import cn.steven.springboot189demo02.entity.Teacher;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

    @RequestMapping("/t3")
    public String t3(@Validated Teacher teacher ,
                     BindingResult bindingResult){
        teacher.validate(bindingResult); //假设 这里验证通过那么就会正常的走下面的逻辑
        return "success";
    }

}
