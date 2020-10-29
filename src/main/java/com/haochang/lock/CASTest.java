package com.haochang.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 描述：cas测试
 * @author: youzhi.gao
 * @date: 2020-09-25 09:03
 */
public class CASTest {
    private static int sum = 0;
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i< 3; i++){
            new Thread(()-> {
                try {
                    lock.lock();

                    sum++;

                    System.out.println(sum);
                }catch (Exception e){

                }finally {
                    lock.unlock();
                }
            }, "thread" + i).start();
        }
    }
}
