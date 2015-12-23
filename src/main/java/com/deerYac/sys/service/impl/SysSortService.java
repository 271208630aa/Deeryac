package com.deerYac.sys.service.impl;

import com.deerYac.sys.bean.TSysProperty;
import com.deerYac.sys.bean.TSysSort;
import com.deerYac.sys.service.BaseTools;
import com.deerYac.sys.service.ServiceInterFace;
import com.deerYac.sys.util.DBUtil;
import com.deerYac.sys.util.Pager;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * 字典类别
 */
@Service
public class SysSortService extends BaseTools implements ServiceInterFace {

    /**
     * 字典列表
     * @param obj
     * @param pager
     * @return
     */
    public List<?> list(Object obj, Pager pager) {
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
        String sql = sb.toString();
        String sqlcount = "select count(1) from (" + sql + ")";
        Object[] params = param.toArray();
        long count = DBUtil.count(sqlcount, params);
        pager.setTotalRows(count);
        List<TSysSort> sorts = DBUtil.queryPageBeanList(pager, sql, TSysSort.class, params);
        return sorts;
    }

    public TSysProperty load(String wid) {
        return baseDao.findById(TSysProperty.class, wid);
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
