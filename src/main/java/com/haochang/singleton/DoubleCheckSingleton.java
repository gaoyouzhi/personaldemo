package com.haochang.singleton;

/**
 * @description: 描述：双重校验单例
 * @author: youzhi.gao
 * @date: 2020-04-17 16:20
 */
public class DoubleCheckSingleton {
    private static volatile DoubleCheckSingleton instance;
    private DoubleCheckSingleton(){

    }

    public static DoubleCheckSingleton getInstance(){
        if(null == instance){
            synchronized (DoubleCheckSingleton.class){
                if(null == instance){
                    instance = new DoubleCheckSingleton();
                }
            }
        }

        return instance;
    }
}
