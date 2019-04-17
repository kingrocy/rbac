package com.yunhui.bean.po;

import lombok.Data;

import java.util.Date;

@Data
public class Role {

    private Long id;

    private Date createTime;

    private Date updateTime;

    private String roleName;

    private String roleDesc;
}