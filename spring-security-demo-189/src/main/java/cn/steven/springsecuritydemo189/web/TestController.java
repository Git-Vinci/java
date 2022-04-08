package cn.steven.springsecuritydemo189.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/t1")
    @PreAuthorize("hasRole('ROLE_ADMIN')") //当前接口需要有 role_admin 这样的权限
    public String t1(){
        return "ROLE_ADMIN";
    }

    @RequestMapping("/t2")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String t2(){
        return "ROLE_USER";
    }

    @RequestMapping("/t3")
    @PreAuthorize("hasRole('ROLE_GUEST')")
    public String t3(){
        return "ROLE_GUEST";
    }
}
