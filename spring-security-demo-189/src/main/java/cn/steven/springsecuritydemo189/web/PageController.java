package cn.steven.springsecuritydemo189.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/index")
    public String index(){
        return "redirect:/index.html";
    }
}
