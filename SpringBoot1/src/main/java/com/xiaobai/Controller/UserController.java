package com.xiaobai.Controller;

import com.xiaobai.model.JsonData;
import com.xiaobai.task.AsyncTask;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.annotation.Target;
import java.util.concurrent.Future;

/**
 * 用户Controller
 *
 * @author 余修文
 * @date 2019/5/13 22:34
 */
@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Resource
    private AsyncTask asyncTask;

    @GetMapping("async_task")
    public JsonData exeTasl() throws InterruptedException {
        long begin = System.currentTimeMillis();

        //asyncTask.task1();
        //asyncTask.task2();
        //asyncTask.task3();

        Future<String> task4 = asyncTask.task4();
        Future<String> task5 = asyncTask.task5();
        Future<String> task6 = asyncTask.task6();

        for (; ; ) {
            if (task4.isDone() && task5.isDone() && task6.isDone()) {
                break;
            }
        }

        long end = System.currentTimeMillis();
        long total = end - begin;
        System.out.println("执行中耗时=" + total);

        return JsonData.buildSuccess();
    }

}
