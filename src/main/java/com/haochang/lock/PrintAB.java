package com.haochang.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 描述：交替打印
 * @author: youzhi.gao
 * @date: 2020-08-13 10:39
 */
public class PrintAB {

}
class FooBar {
    private int n;
    private ReentrantLock lock = new ReentrantLock();
    private Condition fooCondition = lock.newCondition();
    private Condition barCondition = lock.newCondition();
    private boolean flag = true;
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            try {
                lock.lock();
                if(!flag){
                    fooCondition.await();
                    barCondition.signal();
                }

                printFoo.run();
                flag = false;

                barCondition.signal();
            }catch (Exception e){

            } finally {
                lock.unlock();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.

            try {
                lock.lock();
                if(flag){
                    barCondition.await();
                    fooCondition.signal();
                }

                printBar.run();
                flag = true;
                fooCondition.signal();
            }catch (Exception e){

            } finally {
                lock.unlock();
            }
        }
    }
}
