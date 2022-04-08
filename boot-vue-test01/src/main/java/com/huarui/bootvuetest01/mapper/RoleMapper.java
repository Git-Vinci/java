package com.huarui.bootvuetest01.mapper;

import com.huarui.bootvuetest01.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
public interface RoleMapper {
    List<Role> findAll();
}
