package com.yunhui.bean.po;

public class RolePermisson {
    private Integer id;

    private Integer roleId;

    private Integer permissonId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissonId() {
        return permissonId;
    }

    public void setPermissonId(Integer permissonId) {
        this.permissonId = permissonId;
    }

    @Override
    public String toString() {
        return "RolePermisson{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", permissonId=" + permissonId +
                '}';
    }
}