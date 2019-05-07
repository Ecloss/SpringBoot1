package com.xiaobai.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * 用户类
 *
 * @author 余修文
 * @date 2019/5/6 18:13
 */
@Data
public class User {

    private Integer ID;

    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer age;

    @JsonIgnore
    private String pwd;

    @JsonProperty("account")
    private String phone;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date createTime;

    public User(Integer ID, String name, Integer age, String pwd, String phone, Date createTime) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.pwd = pwd;
        this.phone = phone;
        this.createTime = createTime;
    }

    public User() {
    }
}
