package com.yunhui.bean.vo;

import com.yunhui.bean.po.Permission;
import lombok.Data;

import java.util.List;


@Data
public class ManagePermissionVO extends Permission {

    private List<Permission> childPermissions;
}
