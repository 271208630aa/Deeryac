package com.deerYac.sys.bean.extend;

import javax.persistence.Transient;

/**
 * 参数拓展 永远页面参数的显示（如 字典的中文名等）
 * @author jjwang
 *
 */
public class TSysCodeExt {
    protected Integer codecount;

    @Transient
    public Integer getCodecount() {
        return codecount;
    }

    public void setCodecount(Integer codecount) {
        this.codecount = codecount;
    }
}
