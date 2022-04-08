package cn.huarui.controller;

import cn.huarui.entity.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/format")
public class FormatterController {

    @RequestMapping("/register")
    public String register(Teacher teacher){
        System.out.println(teacher);
        return "index2";
    }
}
