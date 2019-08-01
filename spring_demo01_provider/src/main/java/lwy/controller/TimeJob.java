package lwy.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TimeJob {
    @Scheduled(cron = "0/15 * * * * ?")
    public void job(){
        System.out.println("定时任务启动了11");
    }
}
