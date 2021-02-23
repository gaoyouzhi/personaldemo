package com.haochang.designpattern;


/**
 * @description: 描述：holder
 * @author: youzhi.gao
 * @date: 2021-02-22 17:52
 */
public class SingletonHolder {


    enum Singleton{
        INSTANCE;
        private SingletonHolder singletonHolder;

    }

}
