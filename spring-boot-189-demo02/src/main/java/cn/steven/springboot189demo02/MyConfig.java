package cn.steven.springboot189demo02;

import cn.steven.springboot189demo02.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MyConfig {
    @Profile("dev")
    @Bean
    public User user1(){
        User user = new User();
        user.setName("steven");
        return user;
    }

    @Profile("test")
    @Bean
    public User user2(){
        User user = new User();
        user.setName("boone");
        return user;
    }
}