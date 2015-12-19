package com.deerYac.sys.service;

import com.deerYac.sys.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Deeryac
 * Created by jjwang on 2015/12/12 21:28.
 */
public abstract class BaseTools {
    @Autowired
    protected BaseDao baseDao;

}
