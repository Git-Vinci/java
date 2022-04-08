package cn.steven.springboot189demo02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling//开启计时任务
public class SpringBoot189Demo02Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot189Demo02Application.class, args);
    }

}
