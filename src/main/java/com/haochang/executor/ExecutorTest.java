package com.haochang.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 描述：测试线程池
 * @author: youzhi.gao
 * @date: 2020-07-13 14:30
 */
public class ExecutorTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);
        service.shutdown();

        service.shutdownNow();

        service.isShutdown();

        service.isTerminated();

    }
}
