package com.haochang.threadlocal;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 描述：threadlocal 应用场景1
 * @author: youzhi.gao
 * @date: 2020-07-15 09:38
 */
public class ThreadLocalDemo02 {

    public static ExecutorService executorService = Executors.newFixedThreadPool(16);

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    String str = new ThreadLocalDemo02().getDate(finalI);
                    System.out.println(str);
                }
            });

        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }

    private String getDate(int seconds){
        Date date = new Date(1000 * seconds);
        SimpleDateFormat simpleDateFormat = ThreadFormatter.threadLocal.get();

        return simpleDateFormat.format(date);
    }

}

class ThreadFormatter {
    public static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
           return new SimpleDateFormat("mm:ss"); 
       }
    };
}
    
