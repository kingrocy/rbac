package com.yunhui.service;

import com.yunhui.bean.param.RoleAddParam;
import com.yunhui.bean.param.RoleQueryParam;
import com.yunhui.bean.param.RoleUpdateParam;
import com.yunhui.bean.po.Role;
import com.yunhui.bean.vo.ManageRoleVO;
import com.yunhui.common.page.PageResult;


public interface RoleService {

    int addRolePermission(Long roleId, String permissionIds);

    int deleteRolePermissionByRoleId(Long roleId);

    int add(RoleAddParam param);

    int update(RoleUpdateParam param);

    int delete(Long roleId);

    PageResult<Role> listRole(RoleQueryParam param);

    Role getRole(Long roleId);

    ManageRoleVO getRoleVO(Long roleId);
}
