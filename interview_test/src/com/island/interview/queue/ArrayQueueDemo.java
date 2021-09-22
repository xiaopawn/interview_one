package com.island.interview.queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author island
 * @version 1.0 2021/9/21 19:31
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {

        // add remove方法都会抛出异常
        Queue<String> queue = new ArrayBlockingQueue<>(3);
        queue.add("a");
        queue.add("b");
        queue.add("c");
        // 如果添加第四个元素 就会报错队列已满  java.lang.IllegalStateException: Queue full
        // queue.add("d");
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        // 如果多移除了 会报错 java.util.NoSuchElementException
        System.out.println(queue.remove());
    }
}
