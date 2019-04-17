package com.yunhui.bean.vo;

import lombok.Data;

import java.util.List;
@Data
public class ManageAdminDetaiVO {

    private Long id;

    /**
     * 姓名
     */
    private String adminName;

    /**
     * 账号
     */
    private String adminAccount;

    private String adminPhone;

    private String adminNick;

    private String adminPic;

    private List<Long> roleIds;

}
