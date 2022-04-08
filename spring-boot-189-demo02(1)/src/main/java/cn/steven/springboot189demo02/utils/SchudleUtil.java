package cn.steven.springboot189demo02.utils;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchudleUtil {

/*    @Scheduled(fixedDelay= 10000)
    public void t1(){
        System.out.println("计时任务");
    }*/

    @Scheduled(cron= "3 20 10 29 3 ? ")
    public void t2(){
        System.out.println("每天上午10点20执行");
    }
}
