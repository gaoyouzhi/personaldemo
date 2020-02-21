package com.ikang.designpattern;

/**
 * Created by gaoyouzhi on 2020/2/20.
 */
public class LazySingleton {
}
class LazySingle {

    private static volatile LazySingle instance;

    private LazySingle() {

    }

    private static LazySingle getInstance() {
        if (null == instance) {

            synchronized (LazySingle.class) {
                if (null == instance) {
                    instance = new LazySingle();
                }
            }
        }
        return instance;
    }
}