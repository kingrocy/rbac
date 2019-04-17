package com.yunhui.bean.param;

import lombok.Data;

@Data
public class PermissionAddParam {

    private String permissionName;

    private String permissionUrl;

    private Long parentPermissionId;

    private Integer sort;

}
