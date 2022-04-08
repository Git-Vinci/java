package cn.steven.springsecuritydemo189.mapper;

import cn.steven.springsecuritydemo189.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    @Select("select * from student")
    List<Student> queryList();
}
