package cn.huarui.controller;

import cn.huarui.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RestfulController {

    //http://localhost:8082/restful/1/steven
    @GetMapping("/restful/{id}/{name}")
    public String query(@PathVariable("id") int id ,@PathVariable("name") String name) throws JsonProcessingException {
        System.out.println("查询方法,id为:"+id +" ,name:"+name);
        ObjectMapper objectMapper = new ObjectMapper();
        User user = new User();
        user.setSid(1);
        user.setUserName("steven");
        user.setAddress("长沙");
        String s = objectMapper.writeValueAsString(user);
        System.out.println(s);
        return  "index";
    }
    //{"sid":1,"userName":"steven","address":"长沙"}
    @PostMapping("/restful")
    public String insert(@RequestBody User user){
        System.out.println("新增user:"+user);
        return  "index";
    }

    //http://localhost:8082/restful/1/steven
    @DeleteMapping("/restful/{id}/{name}")
    public String delete(@PathVariable("id") int id ,@PathVariable("name") String name){
        System.out.println("删除方法,id为:"+id +" ,name:"+name);
        return  "index";
    }

    //{"sid":1,"userName":"steven","address":"长沙"}
    @PutMapping("/restful")
    public String update(@RequestBody User user){
        System.out.println(user);
        return  "index";
    }
}
