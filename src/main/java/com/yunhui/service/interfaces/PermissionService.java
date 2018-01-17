package com.yunhui.service.interfaces;

import com.yunhui.bean.po.Permisson;
import java.util.List;

/**
 * @Author: Yun
 * @Description:
 * @Date: Created in 2017-12-09 15:44
 */
public interface PermissionService {

    Integer add(Permisson permisson);

    Integer delete(Integer permissonId);

    Integer update(Permisson permisson);

    Permisson selectByPrimaryKey(Integer permissonId);

    List<Permisson> listPermissionWithParName(Permisson permisson);

    List<Permisson> listPermission(Permisson permisson);

    List<Permisson> listPermissionView();

    List<Permisson> getUserPermissons(Integer userId);

}
