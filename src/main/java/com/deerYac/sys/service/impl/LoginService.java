package com.deerYac.sys.service.impl;

import com.deerYac.sys.bean.TSysUser;
import com.deerYac.sys.dao.BaseDao;
import com.deerYac.sys.service.BaseTools;
import com.deerYac.sys.service.ServiceInterFace;
import com.deerYac.sys.util.DBUtil;
import com.deerYac.sys.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class LoginService extends BaseTools {

    /**
     * 根据登录账号加载用户信息
     *
     * @param loginid
     * @return
     */
    public List<TSysUser> findByLoginid(String loginid) {
        if (!StringUtils.isEmpty(loginid)) {
            String sql = " select u.*,dp.name departname from test.t_sys_user u left join t_sys_depart dp on dp.id=u.departid where u.loginid = ?";
            List<TSysUser> users = DBUtil.queryAllBeanList(sql, TSysUser.class, loginid);
            return users;
        }
        return null;
    }

    public List<TSysUser> ss2() {
        String sql = "select * from t_sys_user";
        return DBUtil.queryAllBeanList(sql, TSysUser.class);

    }
}
