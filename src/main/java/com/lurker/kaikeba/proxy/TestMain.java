package com.lurker.kaikeba.proxy;

import com.lurker.kaikeba.proxy.factory.ProxyFactory;
import com.lurker.kaikeba.proxy.target.BaseService;
import com.lurker.kaikeba.proxy.target.impl.FruitStoreImpl;

public class TestMain {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        BaseService baseService = ProxyFactory.build(FruitStoreImpl.class);
        baseService.insert("***例子***");
        baseService.delete();
    }

}
