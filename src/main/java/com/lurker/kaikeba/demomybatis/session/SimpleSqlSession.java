package com.lurker.kaikeba.demomybatis.session;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SimpleSqlSession implements SqlSession {

    private PreparedStatement preparedStatement;

    @Override
    public int insert(String sql) {
        int result = 0;
        try {
            result = preparedStatement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(String sql) {
        return 0;
    }

    @Override
    public int delete(String sql) {
        return 0;
    }

    @Override
    public Object select(String sql) {
        return null;
    }
}
