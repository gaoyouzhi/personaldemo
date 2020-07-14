package com.haochang.thread.character7;


import java.util.LinkedList;

/**
 * @description: 描述：自行实现阻塞队列
 * @author: youzhi.gao
 * @date: 2020-06-24 11:00
 */
public class MyBlockedQueue {
    private int maxSize;

    private LinkedList<Object> queue;

    public MyBlockedQueue(int maxSize, LinkedList<Object> queue) {
        this.maxSize = maxSize;
        this.queue = queue;
    }

    public synchronized void put(Object o) throws InterruptedException {
        while (queue.size() == maxSize){
            wait();
        }

        queue.add(o);
        notifyAll();
    }

    public synchronized Object take() throws InterruptedException {
        while (queue.size() == 0){
            wait();
        }

        Object o = queue.remove();
        notifyAll();
        return o;
    }
}
