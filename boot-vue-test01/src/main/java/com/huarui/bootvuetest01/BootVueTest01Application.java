package com.huarui.bootvuetest01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.huarui.bootvuetest01.mapper")
public class BootVueTest01Application {

    public static void main(String[] args) {
        SpringApplication.run(BootVueTest01Application.class, args);
    }

}
