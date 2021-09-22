package com.island.interview.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author island
 * @version 1.0 2021/9/21 20:10
 */
public class ArrayQueueDemo4 {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);

        queue.offer("a",2, TimeUnit.SECONDS);
        queue.offer("b",2, TimeUnit.SECONDS);
        queue.offer("c",2, TimeUnit.SECONDS);
        // 2秒钟以后会自动终止 不会阻塞
        queue.offer("d",2, TimeUnit.SECONDS);

        System.out.println(queue.poll(2, TimeUnit.SECONDS));
        System.out.println(queue.poll(2, TimeUnit.SECONDS));
        System.out.println(queue.poll(2, TimeUnit.SECONDS));
        System.out.println(queue.poll(2, TimeUnit.SECONDS));
    }
}
