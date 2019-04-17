package com.yunhui.mapper;
import com.yunhui.bean.po.Role;
import com.yunhui.bean.param.RoleQueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* Created by Mybatis Generator 2019/03/12
*/
public interface RoleMapper {

    int deleteByPrimaryKey(Long id);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    Role findByRoleName(@Param("roleName") String roleName);

    List<Role> listRole(RoleQueryParam param);

    int countRole(RoleQueryParam param);

}