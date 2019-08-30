package com.lurker.kaikeba.demomybatis.session.factory;

import com.lurker.kaikeba.demomybatis.session.SimpleSqlSession;
import com.lurker.kaikeba.demomybatis.session.SqlSession;
import com.lurker.kaikeba.demomybatis.session.advise.Invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    @Override
    public SqlSession openSession() {

        SqlSession sqlSession = new SimpleSqlSession();
        InvocationHandler invocation = new Invocation<>(sqlSession);
        SqlSession $proxy = (SqlSession) Proxy.newProxyInstance(sqlSession.getClass().getClassLoader(), sqlSession.getClass().getInterfaces(), invocation);

        return $proxy;
    }
}
