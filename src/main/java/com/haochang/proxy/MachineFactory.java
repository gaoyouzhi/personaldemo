package com.haochang.proxy;

/**
 * @description: 描述：机器工厂
 * @author: youzhi.gao
 * @date: 2020-04-16 14:10
 */
public class MachineFactory implements Factory{
    @Override
    public void create() {
        System.out.println("this is machine factory");
    }
}
