package com.deerYac.sys;

/**
 * Created by super on 2015/12/19.
 */
public interface Const {
    //登陆的用户session key
    public final String LOGIN_USER = "SYSLOGINUSER";
    //验证码的session key
    public final String LOGIN_CAPTCHA = "SYSLOGINCAPTCHA";
    //异常提示信息
    public final String LOGIN_ERROR_MESSAGE = "SYSLOGINERRORMESSAGE";

    public final String LOGIN_USER_MENUS = "SYSLOGINUSERMENU";
    public final int SUCCESS = 1;
    public final int FAILED = 0;
    /*************登陆提示信息*****************/
    public final String MESSAGE_LOGIN_FAILD = "您输入的用户名或密码错误！";
    public final String MESSAGE_LOGIN_USERMUTIPLE = "该账号存在多个用户，请联系管理员！";
    public final String MESSAGE_LOGIN_CAPTCHA = "您输入的验证码错误！";
    public final String MESSAGE_LOGIN_USERDISABLED = "该用户被禁用或失效，请联系管理员！";


    public final String MESSAGE_CONVERT_ERROR = "数据转换错误！";

}
