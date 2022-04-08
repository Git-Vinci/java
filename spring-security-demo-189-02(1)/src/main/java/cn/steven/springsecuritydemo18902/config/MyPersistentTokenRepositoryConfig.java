package cn.steven.springsecuritydemo18902.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
public class MyPersistentTokenRepositoryConfig {
    @Autowired
    private DataSource dataSource;

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        //jdbcTokenRepository.setCreateTableOnStartup(true); 第一次启动项目需要开启，第二次开始就不要了
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }
}
