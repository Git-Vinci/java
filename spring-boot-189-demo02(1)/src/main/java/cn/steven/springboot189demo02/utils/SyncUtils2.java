package cn.steven.springboot189demo02.utils;


import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Component
public class SyncUtils2 {
    @Async
    public Future<String> doInsert(){
        System.out.println("插入信息");
        return  new AsyncResult("插入完成");
    }

    @Async
    public Future<String> doSendEmail(){
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发送邮件");
        return  new AsyncResult("邮件发送完成");
    }

    @Async
    public  Future<String> doSendMessage(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发送短信");
        return  new AsyncResult("短信发送完成");
    }
}
