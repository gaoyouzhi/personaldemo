package com.haochang.thread.character7;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @description: 描述：生产者消费者模式  阻塞队列
 * @author: youzhi.gao
 * @date: 2020-06-24 10:42
 */
public class Producer {
    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(10);
        Runnable producer = () -> {
            while (true) {
                try {
                    queue.put(new Object());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

       new Thread(producer).start();
       new Thread(producer).start();


       Runnable consumer = () -> {
            while (true) {
                try {
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
       };


       new Thread(consumer).start();
       new Thread(consumer).start();
    }
}
