package com.yunhui.dao;
import com.yunhui.bean.po.AdminRole;
import com.yunhui.common.exception.CommonException;
import com.yunhui.mapper.AdminRoleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.yunhui.common.result.ResultCode.DB_OPR_FAIL;

@Component
@Slf4j
public class AdminRoleDAO {


    @Autowired
    AdminRoleMapper adminRoleMapper;

    public List<Long> listRoleIds(Long adminId){
        try {
            return adminRoleMapper.listRoleIds(adminId);
        } catch (Exception e) {
            log.error("listRoleIds exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }

    public List<Long> listPermissionIds(Long adminId){
        try {
            return adminRoleMapper.listPermissionIds(adminId);
        } catch (Exception e) {
            log.error("listPermissionIds exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }


    public int deleteAdminRole(Long id) {
        try {
            return adminRoleMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            log.error("deleteAdminRole exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }

    public int addAdminRole(AdminRole record) {
        try {
            return adminRoleMapper.insertSelective(record);
        } catch (Exception e) {
            log.error("addAdminRole exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }

    public AdminRole getAdminRole(Long id) {
        try {
            return adminRoleMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            log.error("getAdminRole exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }

    public int updateAdminRole(AdminRole record) {
        try {
            return adminRoleMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            log.error("updateAdminRole exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }


    public int deleteByAdminId(Long adminId) {
        try {
            return adminRoleMapper.deleteByAdminId(adminId);
        } catch (Exception e) {
            log.error("deleteByAdminId exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }

    public int deleteByRoleId(Long roleId){
        try {
            return adminRoleMapper.deleteByRoleId(roleId);
        } catch (Exception e) {
            log.error("deleteByRoleId exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }

}
