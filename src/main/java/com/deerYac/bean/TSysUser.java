package com.deerYac.bean;

import com.deerYac.bean.extend.TSysUserExt;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户
 * Created by jjwang on 2015/12/5 19:11.
 */
@Entity
@Table(name = "t_sys_user")
public class TSysUser extends TSysUserExt {
    private String id;
    private String departid;
    private String email;
    private String name;
    private String password;
    private Integer usertype;
    private String loginid;
    private Integer menutype;
    private Integer enable;
    private Date startdate;
    private Date enddate;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "departid")
    public String getDepartid() {
        return departid;
    }

    public void setDepartid(String departid) {
        this.departid = departid;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "usertype")
    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    @Basic
    @Column(name = "loginid")
    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    @Basic
    @Column(name = "menutype")
    public Integer getMenutype() {
        return menutype;
    }

    public void setMenutype(Integer menutype) {
        this.menutype = menutype;
    }

    @Basic
    @Column(name = "enable")
    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    @Basic
    @Column(name = "startdate")
    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    @Basic
    @Column(name = "enddate")
    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TSysUser that = (TSysUser) o;

        if (id != null ? !id.equals(that.id) : that.id != null) {
            return false;
        }
        if (departid != null ? !departid.equals(that.departid) : that.departid != null) {
            return false;
        }
        if (email != null ? !email.equals(that.email) : that.email != null) {
            return false;
        }
        if (name != null ? !name.equals(that.name) : that.name != null) {
            return false;
        }
        if (password != null ? !password.equals(that.password) : that.password != null) {
            return false;
        }
        if (usertype != null ? !usertype.equals(that.usertype) : that.usertype != null) {
            return false;
        }
        if (loginid != null ? !loginid.equals(that.loginid) : that.loginid != null) {
            return false;
        }
        if (menutype != null ? !menutype.equals(that.menutype) : that.menutype != null) {
            return false;
        }
        if (enable != null ? !enable.equals(that.enable) : that.enable != null) {
            return false;
        }
        if (startdate != null ? !startdate.equals(that.startdate) : that.startdate != null) {
            return false;
        }
        if (enddate != null ? !enddate.equals(that.enddate) : that.enddate != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (departid != null ? departid.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (usertype != null ? usertype.hashCode() : 0);
        result = 31 * result + (loginid != null ? loginid.hashCode() : 0);
        result = 31 * result + (menutype != null ? menutype.hashCode() : 0);
        result = 31 * result + (enable != null ? enable.hashCode() : 0);
        result = 31 * result + (startdate != null ? startdate.hashCode() : 0);
        result = 31 * result + (enddate != null ? enddate.hashCode() : 0);
        return result;
    }
}
