package com.yunhui.service.impl;

import com.yunhui.bean.param.RoleAddParam;
import com.yunhui.bean.param.RoleQueryParam;
import com.yunhui.bean.param.RoleUpdateParam;
import com.yunhui.bean.po.Role;
import com.yunhui.bean.po.RolePermission;
import com.yunhui.bean.vo.ManageRoleVO;
import com.yunhui.common.page.PageResult;
import com.yunhui.common.result.ResultCode;
import com.yunhui.dao.AdminRoleDAO;
import com.yunhui.dao.RoleDAO;
import com.yunhui.dao.RolePermissionDAO;
import com.yunhui.service.RoleService;
import com.yunhui.util.BeanCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {


    @Autowired
    RoleDAO roleDAO;

    @Autowired
    RolePermissionDAO rolePermissionDAO;

    @Autowired
    AdminRoleDAO adminRoleDAO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addRolePermission(Long roleId, String permissionIds) {
        String[] permissIds = permissionIds.split(",");
        for (String pid : permissIds) {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(roleId);
            rolePermission.setPermissonId(Long.valueOf(pid));
            rolePermissionDAO.addRolePermission(rolePermission);
        }
        return 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteRolePermissionByRoleId(Long roleId) {
        return rolePermissionDAO.deleteByRoleId(roleId);
    }

    @Override
    public Role getRole(Long roleId) {
        return roleDAO.getRole(roleId);
    }

    @Override
    public ManageRoleVO getRoleVO(Long roleId) {
        Role role = roleDAO.getRole(roleId);
        ManageRoleVO roleVO = BeanCopy.copyTo(role, ManageRoleVO.class);
        //查询这个角色拥有的全部权限
        List<Long> permissionIds = rolePermissionDAO.listPermissionIdsByRoleId(roleId);
        roleVO.setPermissionIds(permissionIds);
        return roleVO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int add(RoleAddParam param) {
        Role role = new Role();
        role.setRoleName(param.getRoleName());
        role.setRoleDesc(param.getRoleDesc());
        int i = roleDAO.addRole(role);
        if (!StringUtils.isEmpty(param.getPermissionIds())) {
            addRolePermission(role.getId(), param.getPermissionIds());
        }
        return i;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(Long roleId) {
        //删除一个角色
        //先删除这个角色所关联的所有权限
        rolePermissionDAO.deleteByRoleId(roleId);
        //再删除和这个角色所关联的所有管理员
        adminRoleDAO.deleteByRoleId(roleId);
        return roleDAO.deleteRole(roleId);
    }

    @Override
    public PageResult<Role> listRole(RoleQueryParam param) {
        List<Role> roles = roleDAO.listRole(param);
        int count = 0;
        if (param.getQueryCount()) {
            count = roleDAO.countRole(param);
        }
        return new PageResult<>(param.getPageNo(),param.getPageSize(),count,roles);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(RoleUpdateParam param) {
        Role role = BeanCopy.copyTo(param, Role.class);
        int i = roleDAO.updateRole(role);
        if (!StringUtils.isEmpty(param.getPermissionIds())) {
            deleteRolePermissionByRoleId(param.getId());
            addRolePermission(role.getId(), param.getPermissionIds());
        }
        return i;
    }

}
