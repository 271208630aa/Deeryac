package com.deerYac.sys.bean;

import com.deerYac.sys.bean.extend.TSysUserRoleExt;

import javax.persistence.*;

/**
 * Created by jjwang on 2015/12/19.
 */
@Entity
@Table(name = "t_sys_user_role")
public class TSysUserRole extends TSysUserRoleExt {
    private String id;
    private String userid;
    private String roleid;

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
    @Column(name = "roleid")
    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TSysUserRole that = (TSysUserRole) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (roleid != null ? !roleid.equals(that.roleid) : that.roleid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (roleid != null ? roleid.hashCode() : 0);
        return result;
    }
}
