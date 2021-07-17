package com.island.interview.juc1;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.*;

/**
 * @author island
 * @version 1.0 2021/7/17 15:44
 */
class ShareData{
    private int number = 1;
    private final Lock lock = new ReentrantLock();
    private final Condition condition1 = lock.newCondition();
    private final Condition condition2 = lock.newCondition();
    private final Condition condition3 = lock.newCondition();
    private final List<Condition> conditions = Arrays.asList(condition1,condition2,condition3);

    private boolean flag;
    public void print(int num,int count){
        lock.lock();
        try {
            while (number != count){
                // condition1.await();
                conditions.get(count - 1).await();
            }
            for (int i = 0; i < num; i++) {
                System.out.print(Thread.currentThread().getName());

            }
            System.out.println();
            number++;
            if (number == count) number = 1;
            conditions.get(number - 1).signal();
//            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
/**
 * 备注：多线程之间按顺序调用，实现A->B->C
 * 三个线程启动，要求如下：
 * AA打印5次，BB打印10次，CC打印15次
 * 接着
 * AA打印5次，BB打印10次，CC打印15次
 * 来10轮
 *      1.高内聚低耦合前提下，线程操作资源类
 *      2.判断/干活/通知
 *      3.多线程交互中，防止虚假唤醒(判断只能用while，不能用if)
 *      4.标志位
 */
public class ConditionDemo6 {

    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareData.print(5,1);

            }
        },"A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareData.print(10,2);
            }
        },"B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareData.print(15,3);
            }
        },"C").start();


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareData.print(20,4);
            }
        },"C").start();

    }
}
