package com.yunhui.service.impl;

import com.yunhui.bean.po.Role;
import com.yunhui.bean.po.RolePermisson;
import com.yunhui.bean.vo.RolePermissonVO;
import com.yunhui.dao.RoleMapper;
import com.yunhui.dao.RolePermissonMapper;
import com.yunhui.service.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Yun
 * @Description:
 * @Date: Created in 2017-12-09 13:59
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    RolePermissonMapper rolePermissonMapper;

    @Override
    public Integer add(Role role) {
        return roleMapper.insertSelective(role);
    }

    @Override
    public Integer delete(Integer roleId) {
        return roleMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public Integer update(Role role) {
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public List<Role> listRole(Role role) {
        return roleMapper.listRole(role);
    }

    @Override
    public Role selectByPrimaryKey(Integer roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public List<RolePermisson> listRolePermisson(Integer roleId) {
        return rolePermissonMapper.listRolePermisson(roleId);
    }

    @Override
    public List<RolePermissonVO> listRolePermissons(Integer roleId) {
        return rolePermissonMapper.listRolePermissons(roleId);
    }

    @Transactional
    @Override
    public Integer batchInsert(List<RolePermisson> rolePermissons) {
        RolePermisson rolePermisson=rolePermissons.get(0);
        rolePermissonMapper.deleteByRoleId(rolePermisson.getRoleId());
        return rolePermissonMapper.batchInsert(rolePermissons);
    }

    @Override
    public Integer deleteByRoleId(Integer roleId) {
        return rolePermissonMapper.deleteByRoleId(roleId);
    }
}
