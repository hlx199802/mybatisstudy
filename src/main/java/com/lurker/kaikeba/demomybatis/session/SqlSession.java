package com.lurker.kaikeba.demomybatis.session;

public interface SqlSession {

    int insert(String sql);

    int update(String sql);

    int delete(String sql);

    Object select(String sql);

}
