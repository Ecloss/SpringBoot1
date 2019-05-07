package com.xiaobai.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 配置文件
 *
 * @author 余修文
 * @date 2019/5/7 17:33
 */
@Data
@Component
//  有了前缀，就不需要添加@Value
@ConfigurationProperties(prefix = "test")
@PropertySource({"classpath:application.properties"})
public class ServerSettings {

    //@Value("${test.name}")
    private String name;

    //@Value("${test.domain}")
    private String domain;

    public ServerSettings() {
    }

    public ServerSettings(String name, String domain) {
        this.name = name;
        this.domain = domain;
    }
}
