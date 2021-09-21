package com.island.interview.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author island
 * @version 1.0 2021/9/4 16:19
 *
 * 可重入锁（递归锁）
 */
class Test implements Runnable{
    public synchronized void method1(){
        System.out.println(Thread.currentThread().getName() + "\t" + "invoke method1");
        method2();
    }

    public synchronized void method2(){
        System.out.println(Thread.currentThread().getName() + "\t" + "invoke method2");
    }



    ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        get();
    }

    private void get() {
        lock.lock();
//        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t" + "invoke get");
            set();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
//            lock.unlock();
        }

    }

    private void set(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t" + "invoke set");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
public class ReentrantLockDemo {

    public static void main(String[] args) {


        Test test = new Test();
        new Thread(test::method1,"t1").start();
        new Thread(test::method1,"t2").start();

        new Thread(test,"t3").start();
        new Thread(test,"t4").start();

    }
}
