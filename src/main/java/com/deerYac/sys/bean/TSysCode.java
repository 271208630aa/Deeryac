package com.deerYac.sys.bean;

import com.deerYac.sys.bean.extend.TSysCodeExt;

import javax.persistence.*;

/**
 * 数据字典
 * Created by jjwang on 2015/12/5 19:08.
 */
@Entity
@Table(name = "t_sys_code")
public class TSysCode extends TSysCodeExt {
    private String id;
    private String upid;
    private String code;
    private String name;
    private String sortcode;
    private String sortname;
    private String flag;
    private String enable;
    private Integer rank;

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
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
    @Column(name = "sortcode")
    public String getSortcode() {
        return sortcode;
    }

    public void setSortcode(String sortcode) {
        this.sortcode = sortcode;
    }

    @Basic
    @Column(name = "sortname")
    public String getSortname() {
        return sortname;
    }

    public void setSortname(String sortname) {
        this.sortname = sortname;
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

    @Basic
    @Column(name = "rank")
    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TSysCode tSysCode = (TSysCode) o;

        if (id != null ? !id.equals(tSysCode.id) : tSysCode.id != null) {
            return false;
        }
        if (upid != null ? !upid.equals(tSysCode.upid) : tSysCode.upid != null) {
            return false;
        }
        if (code != null ? !code.equals(tSysCode.code) : tSysCode.code != null) {
            return false;
        }
        if (name != null ? !name.equals(tSysCode.name) : tSysCode.name != null) {
            return false;
        }
        if (sortcode != null ? !sortcode.equals(tSysCode.sortcode) : tSysCode.sortcode != null) {
            return false;
        }
        if (sortname != null ? !sortname.equals(tSysCode.sortname) : tSysCode.sortname != null) {
            return false;
        }
        if (flag != null ? !flag.equals(tSysCode.flag) : tSysCode.flag != null) {
            return false;
        }
        if (enable != null ? !enable.equals(tSysCode.enable) : tSysCode.enable != null) {
            return false;
        }
        if (rank != null ? !rank.equals(tSysCode.rank) : tSysCode.rank != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (upid != null ? upid.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sortcode != null ? sortcode.hashCode() : 0);
        result = 31 * result + (sortname != null ? sortname.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        result = 31 * result + (enable != null ? enable.hashCode() : 0);
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        return result;
    }
}
