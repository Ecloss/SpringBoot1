package com.xiaobai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.MultipartConfigElement;

/**
 * 所有启动类的入口
 *
 * @author 余修文
 * @date 2019/5/6 16:46
 */
@SpringBootApplication
@EnableScheduling       // 开启定时任务功能
@EnableAsync    // 开启异步任务
public class XdclassApplication {

    public static void main(String[] args) {
        SpringApplication.run(XdclassApplication.class,args);
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 单个文件最大 10M
        factory.setMaxFileSize("10240KB");
        // 设置总上传数据总大小 1GB
        factory.setMaxRequestSize("1024000");
        return factory.createMultipartConfig();
    }

}