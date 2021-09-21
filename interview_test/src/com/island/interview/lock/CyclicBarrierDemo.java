package com.island.interview.lock;

import com.island.interview.enumtest.DragonBallEnum;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author island
 * @version 1.0 2021/9/6 10:35
 *
 * 就如集齐七颗龙珠的例子。可以用来多线程中做统计计算
 */
public class CyclicBarrierDemo {


    static CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() -> {
        System.out.println("成功集齐七颗龙珠，召唤神龙");
    });

    public static void main(String[] args) {

        for (int i = 1; i <= 7; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println("召唤第 " + DragonBallEnum.returnEnum(finalI).getCodeValue() + " 颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }


    }

}
