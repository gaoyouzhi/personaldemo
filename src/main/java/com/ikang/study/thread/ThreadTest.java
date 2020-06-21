package com.ikang.study.thread;

import javax.annotation.security.RunAs;
import java.util.concurrent.*;

/**
 * 继承Thread 创建线程
 * Created by gaoyouzhi on 2020/6/21.
 * @author
 */
public class ThreadTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//
//        MyThread myThread = new MyThread();
//        myThread.start();

//        ExecutorService executors = Executors.newFixedThreadPool(2);
//        executors.submit(new MyCallable<Integer>());

        RunnableTest runnableTest = new RunnableTest();
        runnableTest.run();

        FutureTask futureTask = new FutureTask(new MyCallable<>());
//        Future<?> a = executors.submit(futureTask);
//        Thread.sleep(1000);
//        System.out.println(a.get());
//        a.get();
//        futureTask.run();
//        Object result = futureTask.get();
//        System.out.println(result);
    }

    static class MyThread extends Thread{
        @Override
        public void run(){
            System.out.println("use extend to create thread");
        }

    }

    static class MyCallable<T> implements Callable<T>{

        @Override
        public T call() throws Exception {
            System.out.println("to invoke my callable task");
            Integer a = 1;
            return (T) a;
        }
    }
}
