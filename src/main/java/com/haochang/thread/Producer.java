package com.haochang.thread;

import java.util.concurrent.BlockingQueue;

/**
 * @description: 描述：生产者
 * @author: youzhi.gao
 * @date: 2020-06-23 10:17
 */
public class Producer implements Runnable {
    public volatile boolean canceled = false;

    BlockingQueue storage;

    public Producer(BlockingQueue storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        int num = 0;
        try {

            while (num <= 1000000 && !canceled){
                storage.put(num);
                if(num % 50 == 0){
                    System.out.println(num + "===50的倍数被放入仓库。。。。。。。。。");
                }
                num++;

            }
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            System.out.println("生产者运行结束....");
        }
    }
}
