package com.deerYac.sys.controller;

import com.deerYac.sys.bean.TSysSort;
import com.deerYac.sys.service.impl.SysSortService;
import com.deerYac.sys.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/sys/sort")
public class TSysSortController {
    @Autowired
    private SysSortService sysSortService;

    @RequestMapping(value="/list")
    public String list(TSysSort sort, Pager pager, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
        List<TSysSort> sysSorts = sysSortService.list(sort,pager);
        modelMap.put("result",sysSorts);
        return "sys/sysSort/list.jsp";
    }

    /**
     * 加载信息
     * @param id
     * @return
     */
    @RequestMapping(value="/load")
    public String load(String id,ModelMap modelMap){
        TSysSort sort =  sysSortService.load(id);
        modelMap.put("obj",sort);
        return "sys/sysSort/input.jsp";
    }

}
