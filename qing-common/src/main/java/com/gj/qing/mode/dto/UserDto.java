package com.gj.qing.mode.dto;

import com.gj.qing.base.PageRequest;
import lombok.Data;

/**
 * @Auther: Gaojie
 * @Date: 2023/2/3
 * @Desc:
 */
@Data
public class UserDto extends PageRequest {

    private Long id;

    /**
     * 名字
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 电话
     */
    private Long phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 地址
     */
    private String address;
}
