package com.haochang.threadlocal;

import com.haochang.threadlocal.ThreadLocalDemo.Task;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 描述：测试线程私有
 * @author: youzhi.gao
 * @date: 2020-07-14 11:23
 */
public class ThreadLocalDemo01 {

    static ExecutorService service = Executors.newFixedThreadPool(16);
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");

    public static void main(String[] args) throws InterruptedException {
//        testTwoThreads();
//        testTenThreads();
//        testThousandThreads();
        testThousandThreadsWithOneSDF();
    }

    /**
     * @Description 描述：测试1000个线程共用一个时间解析对象
     * @Param
     * @Returns  
     * @Author: youzhi.gao
     * @Date: 2020-07-15 9:43
     */
    private static void testThousandThreadsWithOneSDF() {

        for (int i = 0; i < 1000; i++) {
            int f = i;
            service.submit(
                    new Runnable(){
                @Override
                public void run() {
                    String str = new ThreadLocalDemo01().dateString(f);
                    System.out.println(str);
                }
            });
        }

        service.shutdown();
    }

    /**
     * @Description 描述：优化 利用线程池执行1000个任务
     * @Param
     * @Returns
     * @Author: youzhi.gao
     * @Date: 2020-07-15 9:43
     */
    private static void testThousandThreads() {
        ExecutorService executorService = Executors.newFixedThreadPool(16);
        for (int i = 0; i < 1000; i++) {
            int f = i;
            executorService.submit(new Thread(()->{
                String str = new ThreadLocalDemo01().dateString(f);
                System.out.println(str);
            }));
        }

        executorService.shutdown();
    }

    /**
     * @Description 描述：10个线程
     * @Param
     * @Returns
     * @Author: youzhi.gao
     * @Date: 2020-07-15 9:44
     */
    private static void testTenThreads() {
        for (int i = 0;i < 10; i++){
            int f = i;
            new Thread(()->{
                String str = new ThreadLocalDemo01().dateString(f);
                System.out.println(str);
            }).start();
        }

    }

    private static void testTwoThreads() throws InterruptedException {
        new Thread(()->{
            String string = new ThreadLocalDemo01().dateString(1);
            System.out.println(string);
        }).start();
        Thread.sleep(100);

        new Thread(()->{
            String str = new ThreadLocalDemo01().dateString(2);
            System.out.println(str);
        }).start();


    }

    public String dateString (int seconds){
        Date date = new Date(1000 * seconds);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");

        return simpleDateFormat.format(date);
    }

}
