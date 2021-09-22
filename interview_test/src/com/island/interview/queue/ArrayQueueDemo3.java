package com.island.interview.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author island
 * @version 1.0 2021/9/21 20:00
 */
public class ArrayQueueDemo3 {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        queue.put("a");
        queue.put("b");
        queue.put("c");
        // 如果阻塞队列长度为3 那么添加第四个元素要一直等待 线程阻塞
        // queue.put("d");

        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());

        // 如果阻塞队列长度为3 那么取出第四个元素要一直等待 线程阻塞
        System.out.println(queue.take());

    }

}
