package com.island.interview.lock;

import com.island.interview.enumtest.CountryEnum;

import java.util.concurrent.CountDownLatch;

/**
 * @author island
 * @version 1.0 2021/9/6 9:47
 *
 * 秦灭7国一统华夏
 * 可以用来多线程初始化一些数据 多线程最后执行。
 */
public class CountDownLatchDemo {

    static CountDownLatch countDownLatch = new CountDownLatch(6);

    public static void main(String[] args) {

        for (int i = 1; i <= 6; i++) {
            final int tempInt = i;
            new Thread(() -> {
//                System.out.println("第 " + tempInt + " 同学离开教室了");
                System.out.println("秦国灭掉 " + CountryEnum.returnEnum(tempInt).getCodeValue() + " 国");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println("班长把教室的门锁了");
        System.out.println("秦灭6国一统华夏");
    }
}
