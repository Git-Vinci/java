package cn.steven.springsecuritydemo189.mapper;

import cn.steven.springsecuritydemo189.entity.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleMapper {

    @Select("select * from t_role where aid = #{aid}")
    @Results(id ="accountMapper", value={
            @Result(column ="id" ,property = "id",id = true),
            @Result(column ="role_name" ,property = "roleName"),
            @Result(column ="aid" ,property = "aid")
    } )
    List<Role> queryRolesByAid(int aid);
}
