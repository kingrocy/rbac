package com.yunhui.bean.po;

public class Permisson {
    private Integer permissonId;

    private String permissonName;

    private String permissonUrl;

    private Integer parentPermissonId;

    private String parentPermissonName;

    private Integer permissonLv;

    public Integer getPermissonId() {
        return permissonId;
    }

    public void setPermissonId(Integer permissonId) {
        this.permissonId = permissonId;
    }

    public String getPermissonName() {
        return permissonName;
    }

    public void setPermissonName(String permissonName) {
        this.permissonName = permissonName == null ? null : permissonName.trim();
    }

    public String getPermissonUrl() {
        return permissonUrl;
    }

    public void setPermissonUrl(String permissonUrl) {
        this.permissonUrl = permissonUrl == null ? null : permissonUrl.trim();
    }

    public Integer getParentPermissonId() {
        return parentPermissonId;
    }

    public void setParentPermissonId(Integer parentPermissonId) {
        this.parentPermissonId = parentPermissonId;
    }

    public Integer getPermissonLv() {
        return permissonLv;
    }

    public void setPermissonLv(Integer permissonLv) {
        this.permissonLv = permissonLv;
    }

    public String getParentPermissonName() {
        return parentPermissonName;
    }

    public void setParentPermissonName(String parentPermissonName) {
        this.parentPermissonName = parentPermissonName;
    }
}