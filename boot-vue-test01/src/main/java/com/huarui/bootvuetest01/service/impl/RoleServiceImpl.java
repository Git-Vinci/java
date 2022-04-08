package com.huarui.bootvuetest01.service.impl;

import com.huarui.bootvuetest01.entity.Role;
import com.huarui.bootvuetest01.mapper.RoleMapper;
import com.huarui.bootvuetest01.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper ;

    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }
}
