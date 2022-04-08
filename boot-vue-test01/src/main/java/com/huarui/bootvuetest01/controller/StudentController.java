package com.huarui.bootvuetest01.controller;

import com.huarui.bootvuetest01.entity.R;
import com.huarui.bootvuetest01.entity.Student;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @RequestMapping("/student")
    public R insertStudent(@RequestBody @Validated Student student,
                           BindingResult result){
        //验证
        student.validate(result);
        return new R.Builder<Student>().buildOk().setData(student);
    }
}
