package com.haochang.proxy;

/**
 * @description: 描述：测试静态代理代理
 * @author: youzhi.gao
 * @date: 2020-04-16 14:15
 */
public class ProxyTest {
    public static void main(String[] args) {
        Factory machineFactory = new MachineFactory();
        Factory m = new ProxyFactory(machineFactory);
        m.create();
    }
}
