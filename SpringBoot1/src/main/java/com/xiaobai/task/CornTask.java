package com.xiaobai.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 定时任务
 *
 * @author 余修文
 * @date 2019/5/13 21:39
 */
@Component
public class CornTask {
    final Integer i = 0;

    //@Scheduled(cron = "*/2 * * * * *")
    public void testTask() {

        System.out.println("当前时间为：" + new Date());
    }


}
