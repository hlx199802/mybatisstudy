package com.lurker.kaikeba.demomybatis;

import com.lurker.kaikeba.demomybatis.session.SqlSession;
import com.lurker.kaikeba.demomybatis.session.factory.DefaultSqlSessionFactory;

public class TestMain {

    public static void main(String[] args) {

        SqlSession session = new DefaultSqlSessionFactory().openSession();
        session.insert("INSERT INTO `dept`(`DNAME`, `LOC`) VALUES ('金融事业部', '北京')");

    }

}
