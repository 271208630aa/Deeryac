package com.deerYac.sys.bean;

import com.deerYac.sys.bean.extend.TSysRoleExt;

import javax.persistence.*;

/**
 * 角色
 * Created by jjwang on 2015/12/5 19:10.
 */
@Entity
@Table(name = "t_sys_role")
public class TSysRole extends TSysRoleExt {
    private String id;
    private String name;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        TSysRole tSysRole = (TSysRole) o;

        if (id != null ? !id.equals(tSysRole.id) : tSysRole.id != null) {
            return false;
        }
        if (name != null ? !name.equals(tSysRole.name) : tSysRole.name != null) {
            return false;
        }
        if (enable != null ? !enable.equals(tSysRole.enable) : tSysRole.enable != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (enable != null ? enable.hashCode() : 0);
        return result;
    }
}
