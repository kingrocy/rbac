package com.yunhui.dao;
import com.yunhui.bean.po.RolePermission;
import com.yunhui.common.exception.CommonException;
import com.yunhui.mapper.RolePermissionMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.yunhui.common.result.ResultCode.DB_OPR_FAIL;

/**
 * Title: RolePermissionDAO.java <br>
 * Description: <br>
 * Copyright (c) 聚阿网络科技版权所有 2019 <br>
 * Create DateTime: 2019年03月12日 19:37 <br>
 *
 * @author yun
 */
@Component
@Slf4j
public class RolePermissionDAO {

    @Autowired
    RolePermissionMapper rolePermissionMapper;

    public List<Long> listPermissionIdsByRoleId(Long roleId){
        try {
            return rolePermissionMapper.listPermissionIdsByRoleId(roleId);
        }catch (Exception e){
            log.error("listPermissionIdsByRoleId exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }

    public int deleteRolePermissionByPermissionId(Long permissionId){
        try {
            return rolePermissionMapper.deleteRolePermissionByPermissionId(permissionId);
        }catch (Exception e){
            log.error("deleteRolePermissionByPermissionId exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }


    public int addRolePermission(RolePermission record){
        try {
            return rolePermissionMapper.insertSelective(record);
        }catch (Exception e){
            log.error("addRolePermission exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }

    public RolePermission getRolePermission(Long id){
        try {
            return rolePermissionMapper.selectByPrimaryKey(id);
        }catch (Exception e){
            log.error("getRolePermission exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }

    public int deleteByRoleId(Long roleId){
        try {
            return rolePermissionMapper.deleteRolePermissionByRoleId(roleId);
        }catch (Exception e){
            log.error("deleteByRoleId exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }
}
