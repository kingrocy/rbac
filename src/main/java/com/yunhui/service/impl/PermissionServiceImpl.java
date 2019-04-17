package com.yunhui.service.impl;

import com.yunhui.bean.param.PermissionUpdateParam;
import com.yunhui.bean.po.Permission;
import com.yunhui.bean.vo.ManagePermissionVO;
import com.yunhui.dao.PermissionDAO;
import com.yunhui.dao.RolePermissionDAO;
import com.yunhui.service.PermissionService;
import com.yunhui.util.BeanCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {


    @Autowired
    PermissionDAO permissionDAO;

    @Autowired
    RolePermissionDAO rolePermissionDAO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int add(Permission permission) {
        if(permission.getParentPermissionId()==null||permission.getParentPermissionId()==0){
            permission.setPermissionLv(Permission.LV_ZERO);
        }else{
            Permission parPermission = permissionDAO.getPermission(permission.getParentPermissionId());
            permission.setPermissionLv(parPermission.getPermissionLv()+1);
        }
        return permissionDAO.addPermission(permission);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(Long permissonId) {
        //先删除rolePermission中的记录
        rolePermissionDAO.deleteRolePermissionByPermissionId(permissonId);
        return permissionDAO.deletePermission(permissonId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(Permission permission) {
        return permissionDAO.updatePermission(permission);
    }

    @Override
    public int update(PermissionUpdateParam param) {
        Permission permission = BeanCopy.copyTo(param, Permission.class);
        permission.setPermissionType(true);
        return permissionDAO.updatePermission(permission);
    }

    @Override
    public Permission get(Long permissonId) {
        return permissionDAO.getPermission(permissonId);
    }

    @Override
    public List<ManagePermissionVO> listPermissionVO(String permissions) {
        return permissionDAO.listPermissionVO(permissions);
    }

    @Override
    public List<String> listPermissionUrls(String permissions) {
        return permissionDAO.listPermissionUrls(permissions);
    }

    @Override
    public List<Permission> listLv1Permission() {
        return permissionDAO.listLv1Permission();
    }


}
