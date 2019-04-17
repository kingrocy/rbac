package com.yunhui.mapper;

import com.yunhui.bean.po.AdminRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* Created by Mybatis Generator 2019/03/12
*/
public interface AdminRoleMapper {

    int deleteByPrimaryKey(Long id);

    int insertSelective(AdminRole record);

    AdminRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdminRole record);

    int deleteByAdminId(@Param("adminId") Long adminId);

    int deleteByRoleId(@Param("roleId") Long roleId);

    List<Long> listPermissionIds(@Param("adminId") Long adminId);

    List<Long> listRoleIds(@Param("adminId") Long adminId);
}