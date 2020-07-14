package com.haochang.demo;

/**
 * Created by gaoyouzhi on 2020/2/9.
 */
public class TestCas {

    static enum ReadyToRun{T1,T2};

    static ReadyToRun r = ReadyToRun.T1;
    public static void main(String[] args) {
        char[] aI = "123456789".toCharArray();
        char[] aC = "ABCDEFGHI".toCharArray();

        new Thread(()->{
            for (char a:
                 aI) {
                while (r != ReadyToRun.T1){
                }
                System.out.println(a);
                r = ReadyToRun.T2;
            }

        }, "t1").start();

        new Thread(()->{
            for (char a:
                    aC) {
                while (r != ReadyToRun.T2){
                }
                System.out.println(a);
                r = ReadyToRun.T1;
            }
        }, "t2").start();

    }
}
