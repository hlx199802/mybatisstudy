package com.lurker.kaikeba.proxy.factory;

import com.lurker.kaikeba.proxy.advise.Invocation;
import com.lurker.kaikeba.proxy.target.BaseService;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    public static <T> T build(Class<? extends T> clazz) throws IllegalAccessException, InstantiationException {
        T object = clazz.newInstance();
        //JDK代理
//        InvocationHandler invocation = new Invocation(object);
//        T proxy = (T) Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), invocation);

        // CGLIB代理
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new net.sf.cglib.proxy.InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                System.out.println("这是前置通知");
                method.invoke(object, objects);
                System.out.println("这是后置通知");
                return null;
            }
        });
        return (T) enhancer.create();
    }

}
