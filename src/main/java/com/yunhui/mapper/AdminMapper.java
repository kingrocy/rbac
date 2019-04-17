package com.yunhui.mapper;


import com.yunhui.bean.po.Admin;
import com.yunhui.bean.param.AdminQueryParam;
import com.yunhui.bean.vo.ManageAdminListVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* Created by Mybatis Generator 2019/03/12
*/
public interface AdminMapper {

    int deleteByPrimaryKey(Long id);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Admin record);

    Admin findByAdminAccount(@Param("account") String account);

    List<ManageAdminListVO> listAdminVO(AdminQueryParam param);

    int countAdminVO(AdminQueryParam param);
}