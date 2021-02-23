package com.haochang.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 描述：交替打印AB
 * @author: youzhi.gao
 * @date: 2020-08-13 10:39
 */
public class PrintAB {

    private int n;
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition aCondition = reentrantLock.newCondition();
    private Condition bCondition = reentrantLock.newCondition();
    private volatile boolean flag = true;

    public PrintAB(int n) {
        this.n = n;
    }

    public static void main(String[] args) {

        PrintAB printAB = new PrintAB(10);

      new Thread(new Runnable() {
          @Override
          public void run() {
              printAB.foo(new Runnable() {
                  @Override
                  public void run() {
                      System.out.print("A");
                  }
              });
          }
      }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                printAB.bar(new Runnable() {
                    @Override
                    public void run() {
                        System.out.print("B");
                    }
                });
            }
        }).start();


    }

    private void foo(Runnable runnable) {

        try {
            reentrantLock.lock();
            for (int i = 0; i < n; i ++){
                if(flag){
                    aCondition.signal();
                } else {
                    aCondition.await();
                }

                runnable.run();
                flag = false;
                bCondition.signal();
            }
        } catch (Exception e){

        } finally {
            reentrantLock.unlock();
        }
    }

    private void bar(Runnable runnable) {

        try {
            reentrantLock.lock();
            for (int i = 0; i < n; i ++){
                if(!flag){
                    bCondition.signal();
                } else {
                    bCondition.await();
                }

                runnable.run();
                flag = true;
                aCondition.signal();
            }
        } catch (Exception e){

        } finally {
            reentrantLock.unlock();
        }
    }
}
class FooBar {
    private int n;
    private ReentrantLock lock = new ReentrantLock();
    private Condition fooCondition = lock.newCondition();
    private Condition barCondition = lock.newCondition();
    private volatile boolean flag = false;
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
