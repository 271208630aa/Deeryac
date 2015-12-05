package com.deerYac.bean;

import com.deerYac.bean.extend.TSysRoleMenuExt;

import javax.persistence.*;

/**
 * 角色菜单
 * Created by jjwang on 2015/12/5 19:08.
 */
@Entity
@Table(name = "t_sys_role_menu")
public class TSysRoleMenu extends TSysRoleMenuExt {
    private String id;
    private String userid;
    private String menuid;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userid")
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "menuid")
    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TSysRoleMenu that = (TSysRoleMenu) o;

        if (id != null ? !id.equals(that.id) : that.id != null) {
            return false;
        }
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) {
            return false;
        }
        if (menuid != null ? !menuid.equals(that.menuid) : that.menuid != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (menuid != null ? menuid.hashCode() : 0);
        return result;
    }
}
