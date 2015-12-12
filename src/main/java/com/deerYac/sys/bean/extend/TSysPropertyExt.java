package com.deerYac.sys.bean.extend;

import javax.persistence.Transient;

/**
 * 参数拓展 永远页面参数的显示（如 字典的中文名等）
 *
 * @author jjwang
 */
public class TSysPropertyExt {
    private String typecn;

    @Transient
    public String getTypecn() {
        return typecn;
    }

    public void setTypecn(String typecn) {
        this.typecn = typecn;
    }
}
