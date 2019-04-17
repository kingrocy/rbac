package com.yunhui.bean.vo;

import lombok.Data;

import java.util.List;

@Data
public class ManageAdminListVO {

    private Long id;

    /**
     * 姓名
     */
    private String adminName;

    private List<String> adminRoleNames;

    /**
     * 账号
     */
    private String adminAccount;


    private String adminPhone;

    private String adminNick;

    private String adminPic;



}
