package com.deerYac.sys.service.impl;

import com.deerYac.sys.bean.TSysProperty;
import com.deerYac.sys.bean.TSysSort;
import com.deerYac.sys.dao.BaseDao;
import com.deerYac.sys.service.BaseTools;
import com.deerYac.sys.service.ServiceInterFace;
import com.deerYac.sys.util.DBUtil;
import com.deerYac.sys.util.Pager;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * 字典类别
 */
@Service
public class SysSortService implements ServiceInterFace {
    @Autowired
    private BaseDao baseService;

    /**
     * 字典列表
     *
     * @param obj
     * @param pager
     * @return
     */
    public List<TSysSort> list(Object obj, Pager pager) {
        TSysSort sort = (TSysSort) obj;
        StringBuilder sb = new StringBuilder("select a.id,a.code,a.flag,a.name,count(b.id) codecount from t_sys_sort a left join t_sys_code b on b.sortcode=a.code where 1=1 ");
        List<Object> param = new LinkedList<Object>();
        if (sort != null) {
            if (StringUtils.isNotBlank(sort.getCode())) {
                sb.append(" and a.code = ? ");
                param.add(sort.getCode());
            }
            if (StringUtils.isNotBlank(sort.getName())) {
                sb.append(" and a.name = ? ");
                param.add(sort.getName());
            }
        }
        sb.append(" group by  a.id,a.code,a.flag,a.name");
        String sql = sb.toString();
        String sqlcount = "select count(1) from (" + sql + ") as a";
        Object[] params = param.toArray();
        long count = DBUtil.count(sqlcount, params);
        pager.setTotalRows(count);
        List<TSysSort> sorts = DBUtil.queryPageBeanList(pager, sql, TSysSort.class, params);
        return sorts;
    }

    public TSysSort load(String id) {
      //  TSysSort sort =  baseService.findById(TSysSort.class, id);
        TSysSort sort = null;
        if (StringUtils.isNotBlank(id)) {
            sort = DBUtil.queryBean("select * from t_sys_sort a where a.id = ? ", TSysSort.class, id);
        }
        return sort;
    }

    public boolean saveOrUpdate(Object obj) {
        return false;
    }

    public long remove(Object obj) {
        return 0;
    }

    public long remove(String wid) {
        return 0;
    }


}
