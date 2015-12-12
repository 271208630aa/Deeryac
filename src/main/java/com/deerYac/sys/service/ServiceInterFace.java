package com.deerYac.sys.service;

import com.deerYac.sys.util.Pager;

import java.util.List;

/**
 * Deeryac
 * Created by jjwang on 2015/12/12 21:35.
 */
public interface ServiceInterFace {
    /**
     * 保存或更新
     * @param obj
     * @return
     */
    public boolean saveOrUpdate(Object obj);

    /**
     *根据对象删除
     * @param obj
     * @return
     */
    public long remove(Object obj);

    /**
     *根据主键删除
     * @param wid
     * @return
     */
    public long remove(String wid);

    /**
     *数据查询
     * @param obj
     * @param pager
     * @return
     */
    public List<?> list(Object obj, Pager pager);

    /**
     *根据主键加载数据
     * @param wid
     * @return
     */
    public Object load(String wid);
}
