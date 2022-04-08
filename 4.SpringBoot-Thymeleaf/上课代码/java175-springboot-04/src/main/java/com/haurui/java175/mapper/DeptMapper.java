package com.haurui.java175.mapper;

import com.haurui.java175.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DeptMapper {
  @Select("SELECT * FROM DEPT WHERE DEPTNO=#{deptno}")
  Dept findByDeptno(int deptno);
}
