package com.deerYac.bean;

import com.deerYac.bean.extend.TSysSortExt;

import javax.persistence.*;

/**
 * 字典大类
 * Created by jjwang on 2015/12/5 19:09.
 */
@Entity
@Table(name = "t_sys_sort")
public class TSysSort extends TSysSortExt {
    private String id;
    private String name;
    private String code;
    private String flag;

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
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "flag")
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TSysSort tSysSort = (TSysSort) o;

        if (id != null ? !id.equals(tSysSort.id) : tSysSort.id != null) {
            return false;
        }
        if (name != null ? !name.equals(tSysSort.name) : tSysSort.name != null) {
            return false;
        }
        if (code != null ? !code.equals(tSysSort.code) : tSysSort.code != null) {
            return false;
        }
        if (flag != null ? !flag.equals(tSysSort.flag) : tSysSort.flag != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        return result;
    }
}
