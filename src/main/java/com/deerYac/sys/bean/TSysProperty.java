package com.deerYac.sys.bean;

import com.deerYac.sys.bean.extend.TSysPropertyExt;

import javax.persistence.*;

/**
 * Deeryac
 * Created by jjwang on 2015/12/12 20:50.
 */
@Entity
@Table(name = "t_sys_property", schema = "", catalog = "test")
public class TSysProperty extends TSysPropertyExt {
    private String wid;
    private String name;
    private String key;
    private String value;
    private String flag;
    private String type;
    private String enable;

    @Id
    @Column(name = "wid")
    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
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
    @Column(name = "key")
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Basic
    @Column(name = "value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TSysProperty that = (TSysProperty) o;

        if (wid != null ? !wid.equals(that.wid) : that.wid != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (key != null ? !key.equals(that.key) : that.key != null) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;
        if (flag != null ? !flag.equals(that.flag) : that.flag != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (enable != null ? !enable.equals(that.enable) : that.enable != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = wid != null ? wid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (key != null ? key.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (enable != null ? enable.hashCode() : 0);
        return result;
    }
}
