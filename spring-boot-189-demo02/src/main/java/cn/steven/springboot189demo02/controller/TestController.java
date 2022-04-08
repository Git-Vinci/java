package cn.steven.springboot189demo02.controller;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
@RestController
@Slf4j
public class TestController {

    @Value("${JAVA_HOME}")
    private String JAVA_HOME;

    @Value("${user.val.birthday}")
    private Date birthday;

    @Value("${user.val.list}")
    private List<String> stringList;

    @RequestMapping("/t1")
    public String t1() {
        System.out.println("birthday:" + birthday);
        System.out.println(stringList);
        System.out.println("JAVA_HOME:" + JAVA_HOME);
        log.info("2222");
        log.debug("2222");
        log.warn("2222");
        return "success";
    }
}
