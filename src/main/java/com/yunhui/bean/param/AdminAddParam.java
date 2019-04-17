package com.yunhui.bean.param;

import lombok.Data;

@Data
public class AdminAddParam {
    /**
     * 姓名
     */
    private String adminName;

    /**
     * 账号
     */
    private String adminAccount;

    /**
     * 密码
     */
    private String adminPassword;

    private String adminPhone;

    private String adminNick;

    private String adminPic;

    private String roleIds;
}
