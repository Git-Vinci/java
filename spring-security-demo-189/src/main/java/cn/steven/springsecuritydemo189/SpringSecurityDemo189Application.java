package cn.steven.springsecuritydemo189;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityDemo189Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDemo189Application.class, args);
    }

}
