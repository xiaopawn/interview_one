package com.island.interview.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author island
 * @version 1.0 2021/8/21 22:12
 */
public class AtomicReferenceDemo2 {

    public static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);

    public static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            // cas 产生aba问题
            System.out.println(atomicReference.compareAndSet(100, 20) + " this current num1 " + atomicReference.get());
            System.out.println(atomicReference.compareAndSet(20, 100) + " this current num2 " + atomicReference.get());

        },"t1").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100, 2021) + " this current num3 " + atomicReference.get());
        },"t2").start();
        System.out.println("=========================");
        TimeUnit.SECONDS.sleep(2);
        new Thread(() -> {
            // cas解决aba问题
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + " 当前的版本为 " + stamp);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + atomicStampedReference.compareAndSet(100, 20, atomicStampedReference.getStamp(),  atomicStampedReference.getStamp() + 1) + " 现在的版本为:" + atomicStampedReference.getStamp() + " 现在的值为：" + atomicStampedReference.getReference());
            System.out.println(Thread.currentThread().getName() + " " + atomicStampedReference.compareAndSet(20, 100, atomicStampedReference.getStamp(),  atomicStampedReference.getStamp() + 1) + " 现在的版本为:" + atomicStampedReference.getStamp() + " 现在的值为：" + atomicStampedReference.getReference());
        },"t3").start();

        new Thread(() -> {
            // cas解决aba问题
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + " 当前的版本为 " + stamp);
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + atomicStampedReference.compareAndSet(100, 2021, stamp, stamp + 1) + " 现在的版本为:" + atomicStampedReference.getStamp() + " 现在的值为：" + atomicStampedReference.getReference());
        },"t4").start();
    }
}
