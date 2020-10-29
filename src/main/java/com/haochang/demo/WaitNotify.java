package com.haochang.demo;

/**
 * Created by gaoyouzhi on 2020/2/9.
 */
public class WaitNotify {
    public static void main(String[] args) {
        final Object o = new Object();
        char[] aI = "123456789".toCharArray();
        char[] aC = "ABCDEFGHI".toCharArray();

        new Thread(()->{
            for (char c:
                    aC) {
                synchronized (o){
                    System.out.print(c);
                    try {
                        o.notify();
                        if(c != aC[aC.length-1]){
                            o.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }, "t2").start();

        new Thread(()->{
            for (char a:
                    aI) {
                synchronized (o){
                    System.out.print(a);
                    try {
                        o.notify();
                        if(a != aI[aC.length-1]){
                            o.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }, "t1").start();
    }
}
