package com.deerYac.sys.controller;

import com.deerYac.sys.Const;
import com.deerYac.sys.bean.TSysMenu;
import com.deerYac.sys.bean.TSysUser;
import com.deerYac.sys.service.impl.LoginService;
import com.deerYac.sys.service.impl.SysMenuService;
import com.deerYac.util.DateUtil;
import com.deerYac.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/login")
public class LoginController extends BaseController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 登陆
     * @param user
     * @param modelMap
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/dologin")
    public String login(TSysUser user, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        //页面输入值判断
        if (user == null || StringUtils.isEmpty(user.getLoginid()) || StringUtils.isEmpty(user.getPassword())) {
            modelMap.put(Const.LOGIN_ERROR_MESSAGE, Const.MESSAGE_LOGIN_FAILD);
        } else {
            //验证码检查
            if (checkCaptcha(user.getCaptcha(), modelMap, request)) {
                //根据登陆账号加载用户
                List<TSysUser> users = loginService.findByLoginid(user.getLoginid());
                //账号属性检查
                TSysUser loginuser = checkLoginUser(users, user.getPassword(), modelMap);
                if (loginuser != null) {
                    HttpSession session = getSession(request);
                    if (session != null) {
                        //用户信息保存到session
                        session.setAttribute(Const.LOGIN_USER, loginuser);
                        return loadUserInfo(modelMap, request);
                    }
                }
            }
        }
        return "manager/login.jsp";
    }

    @RequestMapping(value = "/index")
    public String index(TSysUser user, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = getSession(request);
        if (session != null && session.getAttribute(Const.LOGIN_USER) != null) {
            //已登录用户加载信息
            return loadUserInfo(modelMap, request);
        }
        return login(user, modelMap, request, response);

    }

    /**
     * 加载账号资源
     *
     * @param modelMap
     * @param request
     * @return
     */
    public String loadUserInfo(ModelMap modelMap, HttpServletRequest request) {
        HttpSession session = getSession(request);
        if (session != null) {
            Object obj = session.getAttribute(Const.LOGIN_USER);
            if (obj != null) {
                TSysUser user = (TSysUser) obj;
                if (!StringUtils.isEmpty(user.getId())) {
                    // 加载用户的菜单
                    List<TSysMenu> menus = sysMenuService.loadMenuByUserid(user.getId());
                    session.setAttribute(Const.LOGIN_USER_MENUS, menus);
                    return "manager/main.jsp";
                }
            }
            //session失效
            session.invalidate();
        }
        return "manager/login.jsp";
    }

    /**
     * 验证码检查
     *
     * @param captcha
     * @param modelMap
     * @param request
     * @return
     */
    public boolean checkCaptcha(String captcha, ModelMap modelMap, HttpServletRequest request) {
        if (!StringUtils.isEmpty(captcha)) {
            String sessionCaptcha = findCaptcha(request);
            if (!StringUtils.isEmpty(sessionCaptcha) && captcha.equals(sessionCaptcha)) {
                return true;
            }
        }
        modelMap.put(Const.LOGIN_ERROR_MESSAGE, Const.MESSAGE_LOGIN_CAPTCHA);
        return false;
    }

    /**
     * 获取验证码
     *
     * @param request
     * @return
     */
    public String findCaptcha(HttpServletRequest request) {
        if (request != null) {
            HttpSession session = getSession(request);
            if (session != null) {
                Object obj = session.getAttribute(Const.LOGIN_CAPTCHA);
                if (obj != null) {
                    return String.valueOf(obj);
                }
            }
        }
        return null;
    }

    /**
     * 账号信息检查
     *
     * @return
     */
    public TSysUser checkLoginUser(List<TSysUser> users, String password, ModelMap modelMap) {
        //为查询到账号
        if (users == null || users.size() == 0) {
            modelMap.put(Const.LOGIN_ERROR_MESSAGE, Const.MESSAGE_LOGIN_FAILD);
            return null;
        }
        //同一个账号有两个人使用【虽然系统不允许，但是防止数据维护的时候出现这种情况】
        if (users.size() > 1) {
            modelMap.put(Const.LOGIN_ERROR_MESSAGE, Const.MESSAGE_LOGIN_USERMUTIPLE);
            return null;
        }
        TSysUser user = users.get(0);
        //密码不对
        if (user == null || StringUtils.isEmpty(user.getId()) || StringUtils.isEmpty(password) || !MD5.ecodeByMD5(password).equals(user.getPassword())) {
            modelMap.put(Const.LOGIN_ERROR_MESSAGE, Const.MESSAGE_LOGIN_FAILD);
            return null;
        }

        //是否停用
        int isenable = user.getEnable();
        if (isenable == 0) {
            modelMap.put(Const.LOGIN_ERROR_MESSAGE, Const.MESSAGE_LOGIN_USERDISABLED);
            return null;
        }
        //账号是否过期
        Date starttime = user.getStartdate();
        if (starttime != null && DateUtil.BIGGER == DateUtil.compareBySysDate(starttime)) {
            modelMap.put(Const.LOGIN_ERROR_MESSAGE, Const.MESSAGE_LOGIN_USERDISABLED);
            return null;
        }
        //账号是否过期
        Date endtime = user.getEnddate();
        if (starttime != null && DateUtil.SMALLER == DateUtil.compareBySysDate(endtime)) {
            modelMap.put(Const.LOGIN_ERROR_MESSAGE, Const.MESSAGE_LOGIN_USERDISABLED);
            return null;
        }
        return user;
    }

}
