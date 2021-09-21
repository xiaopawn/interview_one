package com.island.interview.lock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author island
 * @version 1.0 2021/9/6 11:12
 *
 * 可以用抢车位的例子来理解Semaphore
 */
public class SemaphoreDemo {

    static Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args) {

        for (int i = 1; i <= 6; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    semaphore.acquire(); // 设置信号量
                    System.out.println("第 " + finalI + " 成功抢到车位了");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("第 " + finalI + " 离开车位了，可以继续抢车位了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }

            },String.valueOf(i)).start();
        }
    }
}
