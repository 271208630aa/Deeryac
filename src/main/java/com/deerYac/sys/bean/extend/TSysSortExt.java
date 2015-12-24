package com.deerYac.sys.bean.extend;

import javax.persistence.Transient;

/**
 * 参数拓展 永远页面参数的显示（如 字典的中文名等）
 *
 * @author jjwang
 */
public class TSysSortExt {
    protected Integer codecount;
    protected String value;

    @Transient
    public Integer getCodecount() {
        return codecount;
    }

    public void setCodecount(Integer codecount) {
        this.codecount = codecount;
    }

    @Transient
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
