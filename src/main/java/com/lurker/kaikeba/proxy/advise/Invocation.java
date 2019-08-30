package com.lurker.kaikeba.proxy.advise;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 通知
 */
public class Invocation<T> implements InvocationHandler {

    private T target;

    public Invocation(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        transfer();
        result = method.invoke(target, args);
        sail();
        return result;
    }

    private void transfer() {
        System.out.println("==========供货商供给了10箱苹果");
    }

    private void sail() {
        System.out.println("==========收到10箱苹果后，又卖出了3箱");
    }

}
