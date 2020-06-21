package com.ikang.study.thread;

/**
 * Created by gaoyouzhi on 2020/6/21.
 */
public class RunnableTest implements Runnable {
    @Override
    public void run() {
        System.out.println("use implements Runnable to create Thread");
    }
}
