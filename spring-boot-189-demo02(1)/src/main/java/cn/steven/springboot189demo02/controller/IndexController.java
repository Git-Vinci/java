package cn.steven.springboot189demo02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("index")
    public String  index(){
        System.out.println("index");
        return "index.html";
    }
}
