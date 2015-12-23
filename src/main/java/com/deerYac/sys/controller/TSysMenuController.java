package com.deerYac.sys.controller;

import com.deerYac.sys.service.impl.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/sys/menu")
public class TSysMenuController {
    @Autowired
    private SysMenuService sysMenuService;


}
