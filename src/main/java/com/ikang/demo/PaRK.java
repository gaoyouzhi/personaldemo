package com.ikang.demo;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by gaoyouzhi on 2020/2/9.
 */
public class Park {

    static Thread t1 = null, t2 = null;
    public static void main(String[] args) {
        test1();

    }

    private static void test1() {
        char[] num = "123456789".toCharArray();
        char[] chars = "ABCDEFGH".toCharArray();

        t1 = new Thread(()->{
            for (char n : num) {
                System.out.println(n);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        }, "t1");

        t2 = new Thread(()->{
            for (char  c: chars) {
                LockSupport.park();
                System.out.println(c);
                LockSupport.unpark(t1);
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
