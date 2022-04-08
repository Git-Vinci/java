package cn.steven.springboot189demo02.entity;

import lombok.Data;

@Data
public class ValidateResult {

    private int code;

    private String message;

    private Object  data;
}
