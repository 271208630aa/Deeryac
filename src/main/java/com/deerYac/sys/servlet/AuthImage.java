package com.deerYac.sys.servlet;
import com.deerYac.sys.Const;
import com.deerYac.sys.util.CaptchaUtils;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 验证码生成
 */
public class AuthImage extends HttpServlet implements Servlet {
    static final long serialVersionUID = 1L;

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        //生成随机字串
        String verifyCode = CaptchaUtils.generateVerifyCode(4);
        //存入会话session
        HttpSession session = request.getSession(true);
        if(session!=null){
            session.setAttribute(Const.LOGIN_CAPTCHA, verifyCode.toLowerCase());
        }
        //生成图片
        int w = 200, h = 80;
        CaptchaUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
    }
}