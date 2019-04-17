package com.yunhui.bean.vo;

import com.yunhui.bean.po.Role;
import lombok.Data;

import java.util.List;


@Data
public class ManageRoleVO extends Role {

    private List<Long> permissionIds;

}
