package com.yunhui.bean.vo;

import com.yunhui.bean.po.Permisson;

import java.util.List;

/**
 * @Author: Yun
 * @Description:
 * @Date: Created in 2017-12-11 11:06
 */
public class PermissonView extends Permisson{
    private List<Permisson> childPermissons;

    public List<Permisson> getChildPermissons() {
        return childPermissons;
    }

    public void setChildPermissons(List<Permisson> childPermissons) {
        this.childPermissons = childPermissons;
    }
}
