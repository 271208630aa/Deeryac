package com.deerYac.bean;

import com.deerYac.bean.extend.TSysDepartExt;

import javax.persistence.*;

/**
 * 组织机构
 * Created by jjwang on 2015/12/5 19:10.
 */
@Entity
@Table(name = "t_sys_depart")
public class TSysDepart extends TSysDepartExt {
    private String id;
    private String upid;
    private String name;
    private String namepy;
    private String namepyall;
    private Integer type;
    private String layer;
    private String phone;

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
    @Column(name = "namepy")
    public String getNamepy() {
        return namepy;
    }

    public void setNamepy(String namepy) {
        this.namepy = namepy;
    }

    @Basic
    @Column(name = "namepyall")
    public String getNamepyall() {
        return namepyall;
    }

    public void setNamepyall(String namepyall) {
        this.namepyall = namepyall;
    }

    @Basic
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "layer")
    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TSysDepart that = (TSysDepart) o;

        if (id != null ? !id.equals(that.id) : that.id != null) {
            return false;
        }
        if (upid != null ? !upid.equals(that.upid) : that.upid != null) {
            return false;
        }
        if (name != null ? !name.equals(that.name) : that.name != null) {
            return false;
        }
        if (namepy != null ? !namepy.equals(that.namepy) : that.namepy != null) {
            return false;
        }
        if (namepyall != null ? !namepyall.equals(that.namepyall) : that.namepyall != null) {
            return false;
        }
        if (type != null ? !type.equals(that.type) : that.type != null) {
            return false;
        }
        if (layer != null ? !layer.equals(that.layer) : that.layer != null) {
            return false;
        }
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (upid != null ? upid.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (namepy != null ? namepy.hashCode() : 0);
        result = 31 * result + (namepyall != null ? namepyall.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (layer != null ? layer.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
