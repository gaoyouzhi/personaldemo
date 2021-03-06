package com.haochang.thread.character7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 描述：利用Condition  实现生产者消费者
 * @author: youzhi.gao
 * @date: 2020-06-24 10:50
 */
public class ConditionTest {

    private Queue queue;
    private int maxSize;

    private ReentrantLock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public ConditionTest(int maxSize) {
        this.maxSize = maxSize;
        queue = new LinkedList();
    }

    public void put(Object o) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == 0){
                notFull.await();
            }

            queue.add(o);
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == 0){
                notEmpty.await();
            }

            Object o = queue.remove();
            notFull.signalAll();

            return o;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        String a = "复检";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < a.length(); i++){
            char c = a.charAt(i);

            sb.append(String.format("\\u%04x", Integer.valueOf(c)));
        }
        System.out.println(sb.toString());
    }

}
