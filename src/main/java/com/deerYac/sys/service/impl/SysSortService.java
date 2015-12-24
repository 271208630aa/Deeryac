package com.deerYac.sys.service.impl;

import com.deerYac.sys.bean.TSysProperty;
import com.deerYac.sys.bean.TSysSort;
import com.deerYac.sys.dao.BaseDao;
import com.deerYac.sys.service.BaseTools;
import com.deerYac.sys.service.ServiceInterFace;
import com.deerYac.sys.util.DBUtil;
import com.deerYac.sys.util.Pager;
import com.deerYac.sys.util.SeqFactory;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
            if (StringUtils.isNotBlank(sort.getValue())) {
                sb.append(" and b.value = ? ");
                param.add(sort.getValue());
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
        TSysSort sort = baseDao.findById(TSysSort.class, id);
        return sort;
    }

    public boolean saveOrUpdate(Object obj) {
        TSysSort sort = (TSysSort)obj;
        if(sort!=null){
            if(StringUtils.isBlank(sort.getId())){
                sort.setId(SeqFactory.getNewSequenceAlone());
            }
            baseDao.saveOrUpdate(sort);
        }

        return false;
    }

    public long remove(Object obj) {
        return 0;
    }

    public long remove(String wid) {
        return 0;
    }


}
