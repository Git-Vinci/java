package cn.steven.springboot189demo02.controller;

import cn.steven.springboot189demo02.utils.SyncUtils;
import cn.steven.springboot189demo02.utils.SyncUtils2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

@RestController
@Slf4j
public class TestController {

    @Autowired
    SyncUtils syncUtils;

    @Autowired
    SyncUtils2 syncUtils2;


    @RequestMapping("/t1")
    public String t1() {

        log.info("2222");
        log.debug("2222");
        log.warn("2222");

        return "success";
    }

    @RequestMapping("/test")
    public String test(){

        //启动线程去解决这个问题
        //1.需要插入用户的信息
        // doInsertUser();  1S
        syncUtils.doInsert();
        //2.发送邮件通知用户
        // sendMail()   10S
        syncUtils.doSendEmail();
        //3.发送短信提示用户
        //sendMessage();  5S
        syncUtils.doSendMessage();
        //会大大的提高rt时间
        System.out.println("111");
        return  "success";
    }

    @RequestMapping("/test2")
    public String test2() throws ExecutionException, InterruptedException {
        Future<String> stringFuture = syncUtils2.doInsert();
        Future<String> stringFuture1 = syncUtils2.doSendEmail();
        Future<String> stringFuture2 = syncUtils2.doSendMessage();

         while(  !(stringFuture.isDone()
                 && stringFuture1.isDone()
                 && stringFuture2.isDone())){
             //System.out.println("主线程等待");
         }
        System.out.println("插入的结果:"+stringFuture.get());
        System.out.println("邮件发送的结果:"+stringFuture1.get());
        System.out.println("短信发送的结果:"+stringFuture2.get());
        return "success";
    }


}
