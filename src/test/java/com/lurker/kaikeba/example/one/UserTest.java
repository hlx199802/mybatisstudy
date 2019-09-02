package com.lurker.kaikeba.example.one;

import com.alibaba.fastjson.JSON;
import com.lurker.kaikeba.example.BaseTest;
import com.lurker.kaikeba.example.bean.User;
import org.junit.Test;

public class UserTest extends BaseTest {

    @Test
    public void testInsert1() {
        sqlSession.insert("insertUser1");
        sqlSession.commit();
    }

    @Test
    public void testInsert2() {
        User user = new User();
        user.setUserNo(2l);
        user.setUserName("测试2");
        user.setUserAddr("测试地址2");
        sqlSession.insert("insertUser2", user);
        sqlSession.commit();
    }

    @Test
    public void testSelect1() {
        User user = sqlSession.selectOne("selectUser1");
        System.out.println(JSON.toJSONString(user));
    }

    @Test
    public void testSelect2() {
        User user = sqlSession.selectOne("selectUser2", 2);
        System.out.println(JSON.toJSONString(user));
    }

    @Test
    public void testUpdate1() {
        sqlSession.update("updateUser1", "修改测试2");
        sqlSession.commit();
    }

    @Test
    public void testDelete() {
        sqlSession.delete("deleteUser1");
        sqlSession.commit();
    }

}
