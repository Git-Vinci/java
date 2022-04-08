package com.huarui.bootvuetest01.controller;

import com.huarui.bootvuetest01.entity.Role;
import com.huarui.bootvuetest01.service.RoleService;
import com.huarui.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class RoleController {
    @Autowired
    DemoService demoService;

    @Autowired
    RoleService roleService;
    @GetMapping("/role")
    public List<Role> index(){
        System.out.println(demoService);
      return   roleService.findAll();
    }
}
