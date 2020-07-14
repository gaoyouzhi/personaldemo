package com.haochang.threadlocal;

/**
 * @description: 描述：利用threadloca解决线程私有变量问题
 * @author: youzhi.gao
 * @date: 2020-07-14 09:33
 */
public class ThreadLocalDemo {
    static int value = 0;
    public static void main(String[] args) {
        new Thread(new Task()).start();
        new Thread(new Task()).start();
        new Thread(new Task()).start();
        new Thread(new Task()).start();
        new Thread(new Task()).start();
        new Thread(new Task()).start();
        new Thread(new Task()).start();
        new Thread(new Task()).start();
        new Thread(new Task()).start();
        new Thread(new Task()).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(value);
    }

     public static class Task implements Runnable{

        @Override
        public void run() {
            value++;
        }
    }

}
