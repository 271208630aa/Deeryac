package com.deerYac.sys.controller;

import com.deerYac.sys.Const;
import com.deerYac.sys.bean.Message;
import com.deerYac.sys.bean.TSysSort;
import com.deerYac.sys.service.impl.SysSortService;
import com.deerYac.sys.util.DBUtil;
import com.deerYac.sys.util.JsonUtil;
import com.deerYac.sys.util.Pager;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/sys/code")
public class TSysCodeController {
    @Autowired
    private SysSortService sysSortService;

    @RequestMapping(value = "/list")
    public String list(TSysSort sort, Pager pager, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        List<TSysSort> sysSorts = sysSortService.list(sort, pager);
        modelMap.put("result", sysSorts);
        return "sys/sysSort/list.jsp";
    }

    /**
     * 加载信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/load")
    public String load(String id, ModelMap modelMap) {
        TSysSort sort = sysSortService.load(id);
        modelMap.put("obj", sort);
        return "sys/sysSort/input.jsp";
    }

    /**
     * 保存
     * @param sort
     * @param modelMap
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @RequestMapping(value = "/save",produces = { "application/json;charset=UTF-8" })
    public String save(TSysSort sort, ModelMap modelMap) throws JsonProcessingException {
        sysSortService.saveOrUpdate(sort);
        return JsonUtil.obj2json(sort);
    }

    /**
     * 删除
     * @param id
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @RequestMapping(value = "/remove",produces = { "application/json;charset=UTF-8" })
    public String remove(String id) throws JsonProcessingException {
        Message msg = new Message();
        if (StringUtils.isNotBlank(id)) {
            id = id.replaceAll(",", "','");
            String sql = "delete from t_sys_sort a where a.id in ('" + id + "') ";
            int c = DBUtil.executeSQL(sql);
            msg.setState(c > 0 ? Const.SUCCESS : Const.FAILED);
        }
        if(msg.getState()==null){
            msg.setState(Const.FAILED);
        }
        return JsonUtil.obj2json(msg);
    }

    /**
     * 打开新增界面，准备的数据
     * @return
     */
    @RequestMapping(value = "/openinput")
    public String openinput(){
        return "sys/sysCode/input.jsp";
    }

}