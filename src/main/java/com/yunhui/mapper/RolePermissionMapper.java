package com.yunhui.mapper;
import com.yunhui.bean.po.RolePermission;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
* Created by Mybatis Generator 2019/03/12
*/
public interface RolePermissionMapper {

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Long id);

    int deleteRolePermissionByRoleId(@Param("roleId") Long roleId);

    int deleteRolePermissionByPermissionId(@Param("permissionId") Long permissionId);

    List<Long> listPermissionIdsByRoleId(Long roleId);
}