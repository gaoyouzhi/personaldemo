package com.haochang.thread.character6;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @description: 描述：测试volatile
 * @author: youzhi.gao
 * @date: 2020-06-23 10:26
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue storage = new ArrayBlockingQueue(8);
        Producer producer = new Producer(storage);
        Consumer consumer = new Consumer(storage);

        Thread producerThread = new Thread(producer);
        producerThread.start();
        Thread.sleep(500);

        while (consumer.needMoreNums()){
            System.out.println(consumer.storage.take() + "被消费了....");
            Thread.sleep(10);
        }

        System.out.println("不需要消费再多的商品了.....");

        producer.canceled = true;
        System.out.println(producer.canceled);
        producerThread.interrupt();
    }
}
