package com.gj.qing;

import lombok.Data;

/**
 * @Auther: Gaojie
 * @Date: 2023/2/3
 * @Desc:
 */
@Data
public class ResultInfo<T> {

    private T data;
    private int code;
    private String message;


    public ResultInfo() {
    }

    private ResultInfo(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private ResultInfo(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResultInfo<T> success() {
        return new ResultInfo<>(0, "成功");
    }


    public static <T> ResultInfo<T> success(T data) {
        return new ResultInfo<>(0, "成功", data);
    }
}
