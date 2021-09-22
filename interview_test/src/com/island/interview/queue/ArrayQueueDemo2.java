package com.island.interview.queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author island
 * @version 1.0 2021/9/21 19:53
 */
public class ArrayQueueDemo2 {

    public static void main(String[] args) {
        Queue<String> queue = new ArrayBlockingQueue<>(3);
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        // offer 即使多插入一个也不会报错
        queue.offer("d");

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        // 多取一个是null
        System.out.println(queue.poll());
    }
}
