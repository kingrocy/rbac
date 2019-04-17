package com.yunhui.dao;

import com.yunhui.bean.po.Permission;
import com.yunhui.bean.vo.ManagePermissionVO;
import com.yunhui.common.exception.CommonException;
import com.yunhui.mapper.PermissionMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import static com.yunhui.common.result.ResultCode.DB_OPR_FAIL;

/**
 * Title: PermissionDAO.java <br>
 * Description: <br>
 * Copyright (c) 聚阿网络科技版权所有 2019 <br>
 * Create DateTime: 2019年03月12日 14:09 <br>
 *
 * @author yun
 */
@Component
@Slf4j
public class PermissionDAO {

    @Autowired
    PermissionMapper permissionMapper;


    public int deletePermission(Long id){
        try {
            return permissionMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            log.error("deletePermission exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }

    public int addPermission(Permission record){
        try {
            return permissionMapper.insertSelective(record);
        }catch (Exception e){
            log.error("addPermission exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }

    public Permission getPermission(Long id){
        try {
            return permissionMapper.selectByPrimaryKey(id);
        }catch (Exception e){
            log.error("getPermission exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }

    public int updatePermission(Permission record){
        try {
            return permissionMapper.updateByPrimaryKeySelective(record);
        }catch (Exception e){
            log.error("updatePermission exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }

    public List<ManagePermissionVO> listPermissionVO(String permissions){
        try {
            return permissionMapper.listPermissionVO(permissions);
        }catch (Exception e){
            log.error("listPermissionVO exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }


    public List<String> listPermissionUrls(String permissions){
        try {
            return permissionMapper.listPermissionUrls(permissions);
        }catch (Exception e){
            log.error("listPermissionUrls exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }

    public List<Permission> listLv1Permission() {
        try {
            return permissionMapper.listLv1Permission();
        }catch (Exception e){
            log.error("listLv1Permission exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }
}
