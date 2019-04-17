package com.yunhui.service;
import com.yunhui.bean.param.PermissionUpdateParam;
import com.yunhui.bean.po.Permission;
import com.yunhui.bean.vo.ManagePermissionVO;

import java.util.List;


public interface PermissionService {


    int add(Permission permission);

    int delete(Long permissonId);

    int update(Permission permission);

    int update(PermissionUpdateParam param);

    Permission get(Long permissonId);

    List<ManagePermissionVO> listPermissionVO(String permissions);

    List<String> listPermissionUrls(String permissions);

    List<Permission> listLv1Permission();
}
