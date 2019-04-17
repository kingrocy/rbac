package com.yunhui.bean.po;

import lombok.Data;

import java.util.Date;

@Data
public class Admin {

    private Long id;

    private Date createTime;

    private Date updateTime;

    /**
	* 姓名
	*/
    private String adminName;

    private String adminRoleNames;

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

    private Boolean deleted;

}