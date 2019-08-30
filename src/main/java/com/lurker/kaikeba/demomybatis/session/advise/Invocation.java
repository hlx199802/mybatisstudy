package com.lurker.kaikeba.demomybatis.session.advise;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Invocation<T> implements InvocationHandler {

    private T object;
    private PreparedStatement statement;
    private Connection connection;

    public Invocation(T object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object value = null;

        before();

        Field[] fields = object.getClass().getDeclaredFields();
        for(Field field : fields) {
            if(field.getType().getName().equals(PreparedStatement.class.getName())) {
                field.setAccessible(true);
                field.set(object, statement);
            }
        }
        value = method.invoke(object, args);

        after();
        return value;
    }

    private void before() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/kaikeba?characterEncoding=utf8", "root", "Yj940907..");
            statement = connection.prepareStatement("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void after() {
        if(statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
