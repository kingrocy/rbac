package com.yunhui.mapper;

import com.yunhui.bean.po.Permission;
import com.yunhui.bean.vo.ManagePermissionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* Created by Mybatis Generator 2019/03/12
*/
public interface PermissionMapper {

    int deleteByPrimaryKey(Long id);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Permission record);

    List<ManagePermissionVO> listPermissionVO(@Param("permissions") String permissions);

    List<String> listPermissionUrls(@Param("permissions") String permissions);

    List<Permission> listLv1Permission();
}