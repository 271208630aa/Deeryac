package com.deerYac.sys.dao.impl;

import com.deerYac.sys.dao.BaseDao;
import org.hibernate.*;
import org.hibernate.metadata.ClassMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

@Service("baseService")
public final class BaseDaoServiceImpl implements BaseDao {
    private static final Logger log = LoggerFactory.getLogger(BaseDaoServiceImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void delete(String hql, Object... values) {
        executeHql(hql, values);
    }

    /**
     * 删除实体集合
     *
     * @param objects 对象集合
     */
    public void deleteAll(Collection<?> objects) {
        if (objects != null && objects.size() > 0) {
            Session session = sessionFactory.openSession();
            try {
                for (Object entity : objects) {
                    session.delete(entity);
                }
            } catch (Exception e) {
                log.error(e.toString());
            } finally {
                session.close();
            }
        }
    }

    /**
     * 删除
     *
     * @param objectName   对象名称
     * @param paramName    参数名称
     * @param sqlconnector 值连接符
     * @param values       参数使用 “,”（英文逗号）分隔开
     * @return
     */
    public boolean deleteAll(String objectName, String paramName, String sqlconnector, String values) {
        if ((paramName == null) || (sqlconnector == null) || (values == null)
                || (values.length() < 1)) {
            return false;
        }
        return deleteAll(objectName, paramName, sqlconnector, values.split(","));
    }

    /**
     * 删除
     *
     * @param objectName   对象名称
     * @param paramName    参数名称
     * @param sqlconnector 值连接符
     * @param values       参数集合
     * @return
     */
    public boolean deleteAll(String objectName, String paramName, String sqlconnector, Object... values) {
        if ((paramName == null) || (sqlconnector == null) || (values == null)
                || (values.length < 1)) {
            return false;
        }
        StringBuilder hql = new StringBuilder("delete ");
        hql.append(objectName).append(" where ");
        for (Object value : values) {
            if ("=".equals(sqlconnector))
                hql.append(paramName).append(" ").append(sqlconnector)
                        .append(" '").append(value).append("' or ");
            else if ("like".equalsIgnoreCase(sqlconnector))
                hql.append(paramName).append(" ").append(sqlconnector)
                        .append(" '").append(value).append("%' or ");
            else {
                return false;
            }
        }
        hql.delete(hql.lastIndexOf(" or "), hql.length());

        if (log.isInfoEnabled()) {
            log.info(hql.toString());
        }
        delete(hql.toString(), new Object[0]);
        return true;
    }

    /**
     * 保存实体
     */
    public Serializable save(Object object) {
        Session session = sessionFactory.openSession();
        Serializable l = null;
        Transaction tx = session.beginTransaction();

        try {
            //保存用户
            l = session.save(object);
            tx.commit();
        } catch (HibernateException e) {
            log.error(e.toString());
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
        return l;
    }

    public boolean saveAll(List<?> objects) {
        int batchSize = 50;
        if ((objects != null) && (!objects.isEmpty())) {
            Session session = sessionFactory.openSession();
            Transaction tx = session.getTransaction();

            boolean newTrans = false;
            if (tx == null) {
                tx = session.beginTransaction();
                newTrans = true;
            }
            try {
                FlushMode oldFlushMode = session.getFlushMode();
                session.setFlushMode(FlushMode.AUTO);
                int i = 0;
                for (int k = objects.size(); i < k; i++) {
                    session.save(objects.get(i));
                    if ((i % batchSize == 0) || (i == k - 1)) {
                        session.flush();
                        session.clear();
                    }
                }
                if (newTrans) {
                    tx.commit();
                }
                session.setFlushMode(oldFlushMode);
            } catch (HibernateException e) {
                tx.rollback();
                log.error(e.toString());
            } finally {
                session.close();
            }
        }

        return true;
    }

    public boolean saveOrUpdateAll(List<?> objects) {
        int batchSize = 50;
        if ((objects != null) && (!objects.isEmpty())) {
            Session session = sessionFactory.openSession();
            Transaction tx = session.getTransaction();

            boolean newTrans = false;
            if (tx == null) {
                tx = session.beginTransaction();
                newTrans = true;
            }
            try {
                FlushMode oldFlushMode = session.getFlushMode();
                session.setFlushMode(FlushMode.AUTO);
                int i = 0;
                for (int k = objects.size(); i < k; i++) {
                    session.saveOrUpdate(objects.get(i));
                    if ((i % batchSize == 0) || (i == k - 1)) {
                        session.flush();
                        session.clear();
                    }
                }
                if (newTrans) {
                    tx.commit();
                }
                session.setFlushMode(oldFlushMode);
            } catch (HibernateException e) {
                tx.rollback();
                log.error(e.toString());
            } finally {
                session.close();
            }
        }

        return true;
    }


    /**
     * 更新
     *
     * @param object
     */
    public void update(Object object) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            // 取得当前线程Session
            tx = session.beginTransaction();

            //保存用户
            session.update(object);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            log.error(e.toString());
            throw e;
        } finally {
            session.close();
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public void updateNotNull(Object entity) {
        if (entity == null) {
            throw new RuntimeException("被更新的EntityBean为null！");
        }
        ClassMetadata cm = sessionFactory.getClassMetadata(entity.getClass());
        String idProperty = cm.getIdentifierPropertyName();
        if (idProperty == null) {
            throw new RuntimeException("此动态更新方法不支持没有主键属性的EntityBean！");
        }

        Object idPropertyValue = getPojoPropertyValue(entity, idProperty);
        String entityName = cm.getEntityName();
        String[] properties = cm.getPropertyNames();

        List values = new LinkedList();

        StringBuilder hql = new StringBuilder("update ").append(entityName);
        hql.append(" set ");

        for (String property : properties) {
            Object propertyValue = cm.getPropertyValue(entity, property);
            if (propertyValue != null) {
                hql.append(property).append("=").append("?, ");
                values.add(propertyValue);
            }
        }
        values.add(idPropertyValue);
        hql.deleteCharAt(hql.length() - 2);
        hql.append("where ").append(idProperty).append("=?");
        if (log.isInfoEnabled())
            log.info("update object with not null properties ===>>> " + hql);
        try {
            executeHql(hql.toString(), values.toArray());
        } catch (RuntimeException re) {
            log.error(hql.toString());
            log.error("above hql execute failed", re);
            throw re;
        }
    }

    /**
     * 更新列表中实体非空属性
     */

    public void updateNotNullAll(List<?> objects) {
        if ((objects == null) || (objects.size() > 50)) {
            throw new RuntimeException("不能执行此操作：集合为空或者待更新的EntityBean数量大于50个！");
        }
        int i = 0;
        for (int k = objects.size(); i < k; i++) {
            Object entity = objects.get(i);
            updateNotNull(entity);
        }
    }

    /**
     * 保存或更新
     */

    public void saveOrUpdate(Object object) {
        log.debug("saving Object instance");
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(object);
            tx.commit();
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("saveOrUpdate failed", re);
            if (tx != null) {
                tx.rollback();
            }
            throw re;
        } finally {
            session.close();
        }

    }

    /**
     * 根据主键加载数据
     *
     * @param objClass
     * @param id
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T findById(Class<?> objClass, Object id) {
        Session session = sessionFactory.openSession();
        T t = null;
        try {
            t = (T) session.get(objClass, (Serializable) id);
        } catch (Exception e) {
            log.error("findById failed", e);

        } finally {
            session.close();
        }
        return t;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public <T> List<T> findByHql(String sql, Object... para) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(sql);
        if (para != null && para.length > 0) {
            int size = para.length;
            for (int i = 0; i < size; i++) {
                if (para[i] != null) {
                    if ((para[i] instanceof String)) {
                        String new_name = (String) para[i];
                        query.setString(i, new_name);
                    } else if ((para[i] instanceof Integer)) {
                        Integer new_name = (Integer) para[i];
                        query.setInteger(i, new_name.intValue());
                    } else if ((para[i] instanceof BigDecimal)) {
                        BigDecimal new_name = (BigDecimal) para[i];
                        query.setBigDecimal(i, new_name);
                    } else if ((para[i] instanceof Date)) {
                        Date new_name = (Date) para[i];
                        query.setTimestamp(i, new_name);
                    } else if ((para[i] instanceof Map)) {
                        Map map = (Map) para[i];
                        String paramName = (String) map.keySet()
                                .toArray()[0];
                        Object[] params = (Object[]) map.get(paramName);
                        query.setParameterList(paramName, params);
                    } else {
                        query.setParameter(i, para[i]);
                    }
                } else {
                    query.setString(i, null);
                }
            }
        }
        List<T> list = null;
        try {
            list = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    /**
     * 执行hql
     *
     * @param hql
     * @param para 参数集合
     * @return
     */
    @SuppressWarnings("rawtypes")
    public int executeHql(final String hql, final Object... para) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        if (para != null) {
            for (int i = 0; i < para.length; i++) {
                if (para[i] != null) {
                    if ((para[i] instanceof String)) {
                        String new_name = (String) para[i];
                        query.setString(i, new_name);
                    } else if ((para[i] instanceof Integer)) {
                        Integer new_name = (Integer) para[i];
                        query.setInteger(i, new_name.intValue());
                    } else if ((para[i] instanceof BigDecimal)) {
                        BigDecimal new_name = (BigDecimal) para[i];
                        query.setBigDecimal(i, new_name);
                    } else if ((para[i] instanceof Date)) {
                        Date new_name = (Date) para[i];
                        query.setTimestamp(i, new_name);
                    } else if ((para[i] instanceof Map)) {
                        Map map = (Map) para[i];
                        String paramName = (String) map.keySet()
                                .toArray()[0];
                        Object[] params = (Object[]) map.get(paramName);
                        query.setParameterList(paramName, params);
                    } else {
                        query.setParameter(i, para[i]);
                    }
                }
            }
        }
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            int i = query.executeUpdate();
            tx.commit();
            return i;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            log.error(e.toString());
        } finally {
            session.close();
        }
        return -1;
    }

    public static Object getPojoPropertyValue(Object entity, String propertyName) {
        Object value = null;
        try {
            value = BeanUtils.getPropertyDescriptor(entity.getClass(), propertyName);
        } catch (BeansException e) {
            e.printStackTrace();
        }
        return value;
    }
}