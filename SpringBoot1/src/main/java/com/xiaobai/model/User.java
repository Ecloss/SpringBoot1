package com.xiaobai.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户
 *
 * @author 余修文
 * @date 2019/5/8 22:22
 */
@Data
public class User implements Serializable {

    private Integer userId;

    private String name;

    private String password;

    private String salt;

    private Integer state;

    private String createTime;

}
