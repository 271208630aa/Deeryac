package com.deerYac.bean;

import com.deerYac.bean.extend.TSysMenuExt;

import javax.persistence.*;

/**
 * 菜单
 * Created by jjwang on 2015/12/5 19:09.
 */
@Entity
@Table(name = "t_sys_menu")
public class TSysMenu extends TSysMenuExt {
    private String id;
    private String upid;
    private String name;
    private String url;
    private String flag;
    private String enable;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "upid")
    public String getUpid() {
        return upid;
    }

    public void setUpid(String upid) {
        this.upid = upid;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "flag")
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Basic
    @Column(name = "enable")
    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TSysMenu tSysMenu = (TSysMenu) o;

        if (id != null ? !id.equals(tSysMenu.id) : tSysMenu.id != null) {
            return false;
        }
        if (upid != null ? !upid.equals(tSysMenu.upid) : tSysMenu.upid != null) {
            return false;
        }
        if (name != null ? !name.equals(tSysMenu.name) : tSysMenu.name != null) {
            return false;
        }
        if (url != null ? !url.equals(tSysMenu.url) : tSysMenu.url != null) {
            return false;
        }
        if (flag != null ? !flag.equals(tSysMenu.flag) : tSysMenu.flag != null) {
            return false;
        }
        if (enable != null ? !enable.equals(tSysMenu.enable) : tSysMenu.enable != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (upid != null ? upid.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        result = 31 * result + (enable != null ? enable.hashCode() : 0);
        return result;
    }
}
