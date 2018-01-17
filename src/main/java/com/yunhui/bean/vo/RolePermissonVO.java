package com.yunhui.bean.vo;

import com.yunhui.bean.po.Permisson;
import com.yunhui.bean.po.Role;

import java.util.List;

/**
 * @Author: Yun
 * @Description:
 * @Date: Created in 2017-12-11 14:11
 */
public class RolePermissonVO extends Role {

    private Permisson permisson;//角色拥有的权限

    public void setPermisson(Permisson permisson) {
        this.permisson = permisson;
    }

    public Permisson getPermisson() {
        return permisson;
    }
}
