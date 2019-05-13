package com.xiaobai.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * 异步任务类
 *
 * @author 余修文
 * @date 2019/5/13 22:27
 */
@Component
//@Async
public class AsyncTask {

    public void task1() throws InterruptedException {
        Long begin = System.currentTimeMillis();
        Thread.sleep(1000L);
        Long end = System.currentTimeMillis();
        System.out.println("任务1耗时：" + (end - begin));
    }

    public void task2() throws InterruptedException {
        Long begin = System.currentTimeMillis();
        Thread.sleep(2000L);
        Long end = System.currentTimeMillis();
        System.out.println("任务2耗时：" + (end - begin));
    }

    public void task3() throws InterruptedException {
        Long begin = System.currentTimeMillis();
        Thread.sleep(3000L);
        Long end = System.currentTimeMillis();
        System.out.println("任务3耗时：" + (end - begin));
    }

    // 获取异步结果
    public Future<String> task4() throws InterruptedException {
        Long begin = System.currentTimeMillis();
        Thread.sleep(2000L);
        Long end = System.currentTimeMillis();
        System.out.println("任务4耗时：" + (end - begin));
        return new AsyncResult<String>("任务4");
    }

    public Future<String> task5() throws InterruptedException {
        Long begin = System.currentTimeMillis();
        Thread.sleep(3000L);
        Long end = System.currentTimeMillis();
        System.out.println("任务5耗时：" + (end - begin));
        return new AsyncResult<String>("任务5");
    }

    public Future<String> task6() throws InterruptedException {
        Long begin = System.currentTimeMillis();
        Thread.sleep(1000L);
        Long end = System.currentTimeMillis();
        System.out.println("任务6耗时：" + (end - begin));
        return new AsyncResult<String>("任务6");
    }

}
