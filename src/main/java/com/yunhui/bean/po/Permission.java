package com.yunhui.bean.po;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class Permission {

    private Long id;

    private Date createTime;

    private Date updateTime;

    private String permissionName;

    private String permissionUrl;

    @JSONField(serialize = false)
    private Long parentPermissionId;

    @JSONField(serialize = false)
    private Boolean permissionType;

    @JSONField(serialize = false)
    private Integer permissionLv;

    private Integer sort;


    public static final int LV_ZERO=0;
    public static final int LV_ONE=1;
}