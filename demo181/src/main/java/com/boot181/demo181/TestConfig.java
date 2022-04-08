package com.boot181.demo181;

import com.boot181.demo181.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
    @Bean
    public User user(){
        return new User();
    }
}
