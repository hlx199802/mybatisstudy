package com.lurker.kaikeba.proxy.target.impl;

import com.lurker.kaikeba.proxy.target.BaseService;

public class FruitStoreImpl implements BaseService {
    @Override
    public String insert(String name) {
        System.out.println("==========成功插入了一条名称为" + name + "的水果记录");
        return name;
    }

    @Override
    public void delete() {
        System.out.println("==========已经删除所有水果记录");
    }
}
