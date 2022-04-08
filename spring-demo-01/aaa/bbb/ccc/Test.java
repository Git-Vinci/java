package aaa.bbb.ccc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
        User user = context.getBean(User.class);
        user.doSomething("百里春秋");
    }
}
