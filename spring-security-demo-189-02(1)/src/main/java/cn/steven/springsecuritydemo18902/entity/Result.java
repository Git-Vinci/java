package cn.steven.springsecuritydemo18902.entity;

import lombok.Data;

@Data
public class Result {
    private int code;
    private String msg;
    private Object object;
}
