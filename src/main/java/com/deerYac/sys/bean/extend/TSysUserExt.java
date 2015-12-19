package com.deerYac.sys.bean.extend;

import javax.persistence.Transient;

/**
 * 参数拓展 永远页面参数的显示（如 字典的中文名等）
 * @author jjwang
 *
 */
public class TSysUserExt {
    protected String departname;//所属单位名称
    protected String captcha;//验证码


    @Transient
    public String getDepartname() {
        return departname;
    }

    public void setDepartname(String departname) {
        this.departname = departname;
    }

    @Transient
    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
