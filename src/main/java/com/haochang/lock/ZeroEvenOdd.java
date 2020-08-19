package com.haochang.lock;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @description: 描述：打印0 奇数 偶数
 * @author: youzhi.gao
 * @date: 2020-08-13 11:04
 */
public class ZeroEvenOdd {
    private int n;

    private Semaphore z = new Semaphore(1);
    private Semaphore e = new Semaphore(0);
    private Semaphore o = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i = 0; i < n; i++){
            z.acquire();
            printNumber.accept(0);
            System.out.print(0);
            //判断奇数偶数
            if((i&1) == 0){
                o.release();
            } else {
                e.release();
            }
        }

    }

    /**
     * 方法功能描述：打印奇数
     * @MethodName: odd
     * @param printNumber
     * @Return:
     * @Author: yz.gao
     * @Date: 2020-08-13 15:41
     */
    public void odd(IntConsumer printNumber) throws InterruptedException {

        for (int i = 1; i <= n; i += 2){
            o.acquire();
            printNumber.accept(i);
            System.out.print(i);
            z.release();
        }
    }

    /**
     * 方法功能描述：打印偶数
     * @MethodName: even
     * @param printNumber
     * @Return:
     * @Author: yz.gao
     * @Date: 2020-08-13 15:41
     */
    public void even(IntConsumer printNumber) throws InterruptedException {

        for (int i = 2; i <= n; i+=2){
            e.acquire();
            printNumber.accept(i);
            System.out.print(i);
            z.release();
        }
    }



    public static void main(String[] args) throws InterruptedException {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);


    }
}
