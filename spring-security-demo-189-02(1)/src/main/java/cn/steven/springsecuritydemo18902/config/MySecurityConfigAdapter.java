package cn.steven.springsecuritydemo18902.config;

import cn.steven.springsecuritydemo18902.handler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.web.bind.annotation.RequestMethod;

@Configuration
public class MySecurityConfigAdapter  extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsService myUserDetailService;

    @Autowired
    PersistentTokenRepository persistentTokenRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {


         http.csrf().disable();

         http.formLogin()
                 .loginPage("/login.html")
                 .loginProcessingUrl("/login")
                // .failureForwardUrl("/error1")
                 .failureHandler(new MyAuthenticationFailureHandler())
                 .successHandler(new MyAuthenticationSuccessHandler())
                 ;
         http.logout().logoutSuccessHandler(new MylogoutSuccessHandler());
                // .successForwardUrl("/index");

         http.exceptionHandling()
                 .authenticationEntryPoint(new MyAuthenticationEntryPoint())
                 .accessDeniedHandler(new MyAccessDeniedHandler());

         http.authorizeRequests()
                 .antMatchers("/error1","/login","/login.html","/error.html").permitAll()
                 //ROLE_ADMIN
                 .regexMatchers(".+[.]png").hasAnyAuthority("ROLE_ADMIN")
                 .anyRequest().authenticated();

         http.rememberMe()
                 .tokenValiditySeconds(30)
                 .rememberMeParameter("aaa")
                 .userDetailsService(myUserDetailService)
                 .tokenRepository(persistentTokenRepository);
    }
}
