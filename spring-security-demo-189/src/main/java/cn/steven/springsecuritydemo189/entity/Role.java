package cn.steven.springsecuritydemo189.entity;

import lombok.Data;

@Data
public class Role {
    private int id;
    private String roleName;
    private int aid;
}