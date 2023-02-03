package com.gj.qing.exception;


import lombok.Data;

@Data
public class OlsenException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    private Integer errorCode;

    /**
     * 错误信息
     */
    private String errorMsg;

    private OlsenException() {
    }


    public OlsenException(OlsenExceptionEnum exceptionEnum, String msg) {
        super(msg);
        this.errorCode = exceptionEnum.getErrorCode();
        this.errorMsg = msg;
    }


}
