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

    /**
     * 先插入数据，再获取主键；适用于自增主键
     */
    @Test
    public void testInsert3() {
        User user = new User();
        user.setUserNo(4l);
        user.setUserName("测试4");
        user.setUserAddr("测试地址4");
        int row = sqlSession.insert("insertUser3", user);
        sqlSession.commit();
        System.out.println("===============成功插入数据，" + row + ", id为" + user.getUserId());
    }

    /**
     * 先获取主键，再进行插入；适用于非自增主键
     */
    @Test
    public void testInsert4() {
        User user = new User();
        user.setUserNo(4l);
        user.setUserName("测试4");
        user.setUserAddr("测试地址4");
        int row = sqlSession.insert("insertUser4", user);
        sqlSession.commit();
        System.out.println("===============成功插入数据，" + row + ", id为" + user.getUserId());
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
