package com.lurker.kaikeba.beans;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class TestMain {

    public static void main(String[] args) throws IOException {

        Dept dept = new Dept();
        dept.setDname("金融事业部");
        dept.setLoc("北京");

        InputStream is = Resources.getResourceAsStream("MyBatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();
        session.insert("insertDept", dept);
        session.commit();
        session.close();

    }

}
