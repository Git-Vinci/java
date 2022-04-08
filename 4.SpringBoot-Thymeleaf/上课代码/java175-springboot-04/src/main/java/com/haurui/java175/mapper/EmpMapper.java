package com.haurui.java175.mapper;

import com.haurui.java175.entity.Emp;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmpMapper {
  @Select("SELECT * FROM EMP WHERE EMPNO=#{empno}")
  Emp findByEmpno(int empno);

  @Results({
          @Result(property = "mgr", column = "MGR"),
          @Result(property = "deptno", column = "DEPTNO"),
          @Result(property = "manager", column = "MGR", one = @One(select = "com.haurui.java175.mapper.EmpMapper.findByEmpno")),
          @Result(property = "dept", column = "DEPTNO", one = @One(select = "com.haurui.java175.mapper.DeptMapper.findByDeptno"))
  })
  @Select("SELECT * FROM EMP")
  List<Emp> findAll();
}
