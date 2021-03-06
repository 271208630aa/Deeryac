package com.deerYac.sys.bean;

import com.deerYac.sys.bean.extend.TSysRoleMenuExt;

import javax.persistence.*;

/**
 * 角色菜单
 * Created by jjwang on 2015/12/5 19:08.
 */
@Entity
@Table(name = "t_sys_role_menu")
public class TSysRoleMenu extends TSysRoleMenuExt {
    private String id;
    private String roleid;
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
    @Column(name = "roleid")
    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TSysRoleMenu that = (TSysRoleMenu) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (roleid != null ? !roleid.equals(that.roleid) : that.roleid != null) return false;
        return menuid != null ? menuid.equals(that.menuid) : that.menuid == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (roleid != null ? roleid.hashCode() : 0);
        result = 31 * result + (menuid != null ? menuid.hashCode() : 0);
        return result;
    }
}
