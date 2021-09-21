package com.island.interview.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author island
 * @version 1.0 2021/8/21 21:15
 */
public class AtomicDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);



        // 比较并交换
        boolean b = atomicInteger.compareAndSet(0, 2021);
        boolean c = atomicInteger.compareAndSet(0, 1);

        System.out.println(b + "\t" + " this new number:" + atomicInteger.get());
        System.out.println(c + "\t" + " this current number:" + atomicInteger.get());
    }
}
