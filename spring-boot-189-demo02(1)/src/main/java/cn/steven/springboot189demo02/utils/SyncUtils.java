package cn.steven.springboot189demo02.utils;


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class SyncUtils {
    @Async
    public void doInsert(){
        System.out.println("插入信息");
    }

    @Async
    public  void doSendEmail(){
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发送邮件");
    }

    @Async
    public  void doSendMessage(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发送短信");
    }
}
