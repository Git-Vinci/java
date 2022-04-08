package com.haurui.java175.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haurui.java175.entity.Emp;
import com.haurui.java175.mapper.EmpMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
  private final EmpMapper empMapper;

  public MyController(EmpMapper empMapper) {
    this.empMapper = empMapper;
  }

  @RequestMapping("/")
  public String emps(
          @RequestParam(required = false, defaultValue = "1")int pageNum,
          @RequestParam(required = false, defaultValue = "5")int pageSize,
          ModelMap map){
    Page<Emp> page = PageHelper.startPage(pageNum, pageSize);
    empMapper.findAll();
    map.put("page", new PageInfo<>(page));
    return "emps";
  }
}
