package com.yunhui.dao;

import com.yunhui.bean.po.Role;
import com.yunhui.bean.param.RoleQueryParam;
import com.yunhui.common.exception.CommonException;
import com.yunhui.mapper.RoleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.yunhui.common.result.ResultCode.DB_OPR_FAIL;

/**
 * Title: RoleDAO.java <br>
 * Description: <br>
 * Copyright (c) 聚阿网络科技版权所有 2019 <br>
 * Create DateTime: 2019年03月12日 14:08 <br>
 *
 * @author yun
 */
@Component
@Slf4j
public class RoleDAO {

    @Autowired
    RoleMapper roleMapper;


    public List<Role> listRole(RoleQueryParam param){
        try {
            return roleMapper.listRole(param);
        }catch (Exception e){
            log.error("listRole exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }

    public int countRole(RoleQueryParam param){
        try {
            return roleMapper.countRole(param);
        }catch (Exception e){
            log.error("countRole exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }

    public Role findByRoleName(String roleName){
        try {
            return roleMapper.findByRoleName(roleName);
        }catch (Exception e){
            log.error("findByRoleName exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }


    public int deleteRole(Long id){
        try {
            return roleMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            log.error("deleteRole exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }

    public int addRole(Role record){
        try {
            return roleMapper.insertSelective(record);
        }catch (Exception e){
            log.error("addRole exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }

    public Role getRole(Long id){
        try {
            return roleMapper.selectByPrimaryKey(id);
        }catch (Exception e){
            log.error("getRole exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }

    public int updateRole(Role record){
        try {
            return roleMapper.updateByPrimaryKeySelective(record);
        }catch (Exception e){
            log.error("updateRole exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }
}
