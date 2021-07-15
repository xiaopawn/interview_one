package com.island.interview.juc1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author island
 * @version 1.0 2021/7/13 12:30
 */
public class MultiThread {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "C").start();

       /*
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {

                    ticket.sale();

                }
            }
        }, "A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {

                    ticket.sale();

                }
            }
        }, "B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {

                    ticket.sale();

                }
            }
        }, "C").start();
    }*/
    }
}

/**
 * 资源类
 */
class Ticket {
    private int number = 30;

    Lock lock = new ReentrantLock();

    public void sale() {

        lock.lock();
        try {
            if (number > 0){
                System.out.println(Thread.currentThread().getName() + "------卖出了：" + number-- + "，还剩：" + number);
            }else {
                lock.unlock();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        System.out.println(number);
    }
}
