package com.xiaobai.Controller;

import com.xiaobai.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试类
 *
 * @author 余修文
 * @date 2019/5/6 15:54
 */
// ResponseBody + Controller
@RestController
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

    @RequestMapping(value = "/test")
    public Map<String, String> testMap() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "XiaoBai");
        return map;
    }

    @GetMapping(value = "/test/json")
    public Object testJson() {

        return new User(01, "XiaoBai", null, "19982", "123321", new Date());
    }

}
