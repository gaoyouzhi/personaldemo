package com.haochang.proxy;

/**
 * @description: 描述：代理工厂
 * @author: youzhi.gao
 * @date: 2020-04-16 14:11
 */
public class ProxyFactory implements Factory {

    MachineFactory machineFactory;

    public ProxyFactory(Factory machineFactory){
        if(MachineFactory.class == machineFactory.getClass()){
            this.machineFactory = (MachineFactory) machineFactory;
        }
    }

    @Override
    public void create() {
        machineFactory.create();
    }
}
