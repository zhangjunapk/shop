package org.zj.shop.util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

public class DBUtil {

    @Autowired
    static SqlSession sqlSession;

    static ThreadLocal<SqlSession> threadLocal;
    static SqlSessionFactory sqlSessionFactory;
    static{/*
        InputStream is=DBUtil.class.getClassLoader().getResourceAsStream("/static/db.properties");
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);*/
    }

    public static SqlSession getSession(){
        if(threadLocal.get()==null){
            threadLocal.set(sqlSessionFactory.openSession());
        }
        return threadLocal.get();
    }

    public static boolean release(){
        getSession().close();
        threadLocal.remove();
        return true;
    }

    public static boolean commitAndClose(){
        getSession().commit();
        release();
        return true;
    }
    public static boolean rollbackAndClose(){
        getSession().rollback();
        release();
        return true;
    }

    public static List<Object[]> getListResult(String sql)  {
        List<Object[]> query = null;
        try {
            query = new QueryRunner().query(sqlSession.getConnection(), sql, new ArrayListHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        release();
        return query;
    }

}
