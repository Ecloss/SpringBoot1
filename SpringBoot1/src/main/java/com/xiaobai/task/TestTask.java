package com.xiaobai.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 定时任务
 *
 * @author 余修文
 * @date 2019/5/13 21:27
 */
@Component
public class TestTask {

    /**
     * fixedRate = 2000
     * 定时任务为2s
     * fixedRate：代表多久执行一次
     * fixedDelay：代表上一次执行结束时间点后xx秒在进行执行
     */
    //@Scheduled(fixedRate = 2000)
    //@Scheduled(fixedRateString = "2000")
    public void sum() throws InterruptedException {
        Thread.sleep(4000L);
        System.out.println("当前时间：" + new Date());
    }

}
