package cn.huarui.controller;



import cn.huarui.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
@SessionAttributes("user")
public class TestController {

    static Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/test8")

    public String test8(ModelMap model){
        System.out.println("test8方法被调用");
        logger.info("test8方法被调用");
        User user = new User();
        user.setSid(1);
        user.setUserName("百里春秋modelMap");
        user.setAddress("长沙");
        model.addAttribute("user",user);
        return "index";
    }

    @RequestMapping("/test7")
    public String test7(Model model){
        System.out.println("test7方法被调用");
        logger.info("test7方法被调用");
        User user = new User();
        user.setSid(1);
        user.setUserName("百里春秋model");
        user.setAddress("长沙");
        model.addAttribute("user",user);
        return "index";
    }

    @RequestMapping("/test6")
    public String test6(Map<String,Object> mappppppp){
        System.out.println("test6方法被调用");
        logger.info("test6方法被调用");
        User user = new User();
        user.setSid(1);
        user.setUserName("百里春秋");
        user.setAddress("长沙");
        mappppppp.put("user",user);
        return "index";
    }


    @RequestMapping("/test5")
    public void test5(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        System.out.println("test5方法被调用");
        logger.info("test5方法被调用");
        System.out.println(request);
        System.out.println(response);
        request.getRequestDispatcher("/test").forward(request,response);
    }

    @RequestMapping("/test4")
    public String test4(){
        System.out.println("test4方法被调用");
        logger.info("test4方法被调用");
        //return "redirect:/test";
        return "redirect:/index2.jsp";
    }

    @RequestMapping("/test3")
    public ModelAndView test3(){
        System.out.println("test3方法被调用");
        logger.info("test3方法被调用");
        ModelAndView modelAndView = new ModelAndView();
       // modelAndView.setViewName("/index.jsp");  //因为在试图解析器中配置了前后缀，所以不需要这么写路径s
        User user = new User();
        user.setSid(1);
        user.setUserName("百里春秋");
        user.setAddress("长沙");
        modelAndView.setViewName("index");
        modelAndView.setStatus(HttpStatus.OK);
        modelAndView.addObject("user",user);
        return modelAndView;
    }



    @RequestMapping("/test2")
    @ResponseBody //如果不加这个那么一定会出现路径的跳转
    public void  test2(){
        System.out.println("test2方法被调用");
        logger.info("test2方法被调用");
    }

    @RequestMapping("/test")
    public String  test(){
        System.out.println("test方法被调用");
        logger.info("test方法被调用");
        return "index2";
    }

    @RequestMapping("/query")
    public String  query(){
        System.out.println("query方法被调用");
        logger.info("query方法被调用");
        return "index";
    }

    @RequestMapping("/insert")
    public String  insert(){
        System.out.println("insert方法被调用");
        logger.info("insert方法被调用");
        return "index";
    }

    @RequestMapping("/delete")
    public String  delete(){
        System.out.println("delete方法被调用");
        logger.info("delete方法被调用");
        return "index";
    }

    @RequestMapping("/update")
    public String  update(){
        System.out.println("update方法被调用");
        logger.info("update方法被调用");
        return "index";
    }
}
