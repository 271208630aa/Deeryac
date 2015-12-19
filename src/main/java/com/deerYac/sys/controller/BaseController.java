package com.deerYac.sys.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by super on 2015/12/19.
 */
public class BaseController {
    public HttpSession getSession(HttpServletRequest request) {
        if (request != null) {
            return request.getSession(true);
        }
        return null;
    }

}
