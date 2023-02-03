package com.gj.qing.exception;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public enum OlsenExceptionEnum {

    /**
     * 枚举值
     */
    DATA_NOT_EXIST(93, "数据不存在！"),
    SE_ILLEGAL_REQUEST_EXCEPTION(94, "非法操作"),
    SE_NEED_LOGIN_EXCEPTION(96, "请先登录"),
    SE_ACTION_NOT_EXISTS_EXCEPTION(97, "接口不存在"),
    SE_APPINFO_ERROR_EXCEPTION(99, "不支持此客户端或者此版本,请进行升级!"),

    UNKNOWN_EXCEPTION(9999, "未知异常"),
    SYSTEM_ERROR(8888, "系统错误"),
    NON_PARAMS_EXCEPTION(-1, "入参为空"),
    PARAMS_ERROR_EXCEPTION(-1, "参数错误"),
    MISSING_PARAMS_EXCEPTION(-1, "缺少参数"),
    HTTP_ERROR_EXCEPTION(-1, "请求错误"),
    FLOW_LIMIT_COMPONENT_EXCEPTION(-1, "接口访问太快了，请稍后访问"),
    OPERATION_FAIL(-1, "操作失败"),
    FORBIDDEN(403, "无权访问该接口"),
    ;

    /**************************************** 我是一条分割线 ****************************************/

    @Getter
    @Setter
    private Integer errorCode;

    @Getter
    @Setter
    private String errorMsg;

}

