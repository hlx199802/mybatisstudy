package com.lurker.kaikeba.demomybatis.session.factory;

import com.lurker.kaikeba.demomybatis.session.SqlSession;

public interface SqlSessionFactory {

    SqlSession openSession();

}
