package com.yunhui.common.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum ResultCode {

    ADMIN_NOT_EXIST(-41,"账号不存在"),
    ADMIN_PASSWD_ERROR(-42,"密码错误"),
    ADMIN_DELETE(-43,"此账号已被删除"),
    PASSWORD_UNVALID(-44,"密码必须为数字和字母组合共6-20位"),
    OLD_PASSWORD_ERROR(-45,"旧密码输入错误，请重新输入"),


    DB_OPR_FAIL(-11, "数据库操作异常"),

    NO_AUTH(-5,"无权限访问"),
    PARAMS_EXCEPTION(-2, "参数类型异常"),
    RUNTIME_EXCEPTION(-1, "业务处理异常"),
    SUCCESS(0, "业务处理成功");

    private int code;
    private String message;


}
