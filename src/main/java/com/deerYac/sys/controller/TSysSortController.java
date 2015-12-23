package com.deerYac.sys.controller;

import com.deerYac.sys.bean.TSysSort;
import com.deerYac.sys.service.impl.SysMenuService;
import com.deerYac.sys.service.impl.SysSortService;
import com.deerYac.sys.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/sys/menu")
public class TSysSortController {
    @Autowired
    private SysSortService sysSortService;

    @RequestMapping(value="/list")
    public String list(TSysSort sort, Pager pager, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
        sysSortService.list(sort,pager);
        return "sys/sysProperty/list.jsp";
    }

}
