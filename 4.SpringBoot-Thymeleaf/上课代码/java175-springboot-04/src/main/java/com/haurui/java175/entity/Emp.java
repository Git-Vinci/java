package com.haurui.java175.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ToString(exclude = {"manager", "dept"})
public class Emp {
  private Integer empno;
  private String ename, job;
  private Integer mgr;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date hiredate;
  private Double sal, comm;
  private Integer deptno;

  private Emp manager; //mgr
  private Dept dept; //deptno
}
