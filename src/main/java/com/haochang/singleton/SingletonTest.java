package com.haochang.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * @description: 描述：测试单例
 * @author: youzhi.gao
 * @date: 2020-04-17 16:24
 */
public class SingletonTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);

    }

    class Task implements Runnable{

        @Override
        public void run() {
            System.out.println(DoubleCheckSingleton.getInstance() + ":" + Thread.currentThread().getName());
        }
    }
}
