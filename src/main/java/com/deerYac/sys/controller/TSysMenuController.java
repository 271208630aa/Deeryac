package com.deerYac.sys.controller;

import com.deerYac.sys.bean.TSysUser;
import com.deerYac.sys.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value="/sys/menu")
public class TSysMenuController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/list")
	public String list(Model model){
		List<TSysUser> users =  userService.ss2();
		model.addAttribute("data", users);
		return "user/list.jsp";
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/load")
	public String load(Model model){
		TSysUser  sysUser = userService.findById("1");
		model.addAttribute("obj", sysUser);
		return "user/entity.jsp";
		
	}
	
}
