package com.xiaobai.Controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试类
 *
 * @author 余修文
 * @date 2019/5/6 15:54
 */
@Controller
@EnableAutoConfiguration
public class SampleController {

    /**
     * 快速创建第一步：
     * 1.   <parent>
     *
     *     <groupId>org.springframework.boot</groupId>
     *     <artifactId>spring-boot-starter-web</artifactId>
     *     <version>2.0.1.RELEASE</version>
     *
     *   </parent>
     *
     *     <dependency>
     *       <groupId>org.springframework.boot</groupId>
     *       <artifactId>spring-boot-starter-web</artifactId>
     *       <version>2.0.1.RELEASE</version>
     *     </dependency>
     *  2. 写一个简单的Controller
     *
     */
    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello World，I am XiaoBai";
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleController.class, args);
    }

}
