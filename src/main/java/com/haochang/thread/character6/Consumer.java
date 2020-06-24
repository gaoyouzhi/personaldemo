package com.haochang.thread.character6;

import java.util.concurrent.BlockingQueue;

/**
 * @description: 描述：消费者
 * @author: youzhi.gao
 * @date: 2020-06-23 10:23
 */
public class Consumer {
    BlockingQueue storage;

    public Consumer(BlockingQueue storage) {
        this.storage = storage;
    }

    public boolean needMoreNums(){
        if(Math.random() > 0.97){
            return false;
        }

        return true;
    }
}
