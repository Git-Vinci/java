package cn.huarui.controller;

import cn.huarui.entity.Result;
import cn.huarui.entity.Student;
import cn.huarui.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class ParameterController {

        @RequestMapping("/save")
        public String save(MultipartFile headImg, String username ) throws IOException {
            System.out.println(username);
            System.out.println("文件名:"+headImg.getOriginalFilename());
            System.out.println("文件大小:"+headImg.getBytes());
            headImg.transferTo(new File("F:\\img\\"+headImg.getOriginalFilename()));
            return  "index";
        }

      @RequestMapping("/insert")
     public String insert(User user ){
          System.out.println("insert方法被调用");
          return  "index2";
      }

    @RequestMapping("/delete")
    public String delete(String[] sids){
        System.out.println("delete方法被调用");
        System.out.println(Arrays.toString(sids));
        return  "index2";
    }

    @RequestMapping("/update")
    public String update(Student s){
        System.out.println("update方法被调用");
        System.out.println(s);
        return  "index2";
    }
}
