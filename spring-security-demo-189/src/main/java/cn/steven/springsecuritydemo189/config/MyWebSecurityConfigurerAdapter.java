package cn.steven.springsecuritydemo189.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class MyWebSecurityConfigurerAdapter  extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/login.html","/login")//对login.html他不做权限校验
                .permitAll()
                .anyRequest() //针对任何的请求
                .authenticated();//需要验证

        http.formLogin()
                .loginPage("/login.html")//登录页面
                .loginProcessingUrl("/login") //登录的路径
                .successForwardUrl("/index");

        http.csrf().disable();
    }
}
