package com.deerYac.sys.service.impl;

import com.deerYac.sys.bean.TSysProperty;
import com.deerYac.sys.service.BaseService;
import com.deerYac.sys.service.ServiceInterFace;
import com.deerYac.sys.util.DBUtil;
import com.deerYac.sys.util.Pager;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class SysPropertyService extends BaseService implements ServiceInterFace {

	public List<?> list(Object obj, Pager pager) {
		TSysProperty bean = (TSysProperty) obj;
		List<Object> param = new LinkedList<Object>();
		StringBuilder hqlBuiler = new StringBuilder("select a.wid,a.name,a.key,a.value,a.type,zd.name typecn,a.enable from t_sys_property a left join t_sys_code zd on zd.sortcode='paramtypes' and zd.code=a.type where 1=1 ");
		if(bean!=null){
			if(StringUtils.isNotBlank(bean.getKey())){
				hqlBuiler.append(" and a.key = ? ");
				param.add(bean.getKey());
			}
			if(StringUtils.isNotBlank(bean.getValue())){
				hqlBuiler.append(" and a.value = ? ");
				param.add(bean.getValue());
			}
			if(StringUtils.isNotBlank(bean.getEnable())){
				hqlBuiler.append(" and a.enable = ? ");
				param.add(bean.getEnable());
			}
			if(StringUtils.isNotBlank(bean.getName())){
				hqlBuiler.append(" and a.name = ? ");
				param.add(bean.getName());
			}
			if(StringUtils.isNotBlank(bean.getType())){
				hqlBuiler.append(" and a.type = ? ");
				param.add(bean.getType());
			}
			if(StringUtils.isNotBlank(bean.getFlag())){
				hqlBuiler.append(" and instr(a.flag , ? ) > 0 ");
				param.add(bean.getFlag());
			}
		}

		String sql = hqlBuiler.toString();
		Object [] param_obj = param.toArray();
		long count = DBUtil.count("select count(1) from ("+sql+")",param_obj);
		pager.setTotalRows(count);
		List<TSysProperty> sysProperties =  DBUtil.queryPageBeanList(pager, sql, TSysProperty.class, param_obj);
		return sysProperties;
	}

	public TSysProperty load(String wid){
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
