package com.maoqin.movie.utils.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
@Configuration
@EnableScheduling
public class MovieTask {

    //编写需要定时执行的方法
    @Scheduled(cron = "*/10 * * * * ?")
    public void task(){
        System.out.println("现在是北京时间："+new Date());
    }
}
