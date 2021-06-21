package com.island.interview.singletontest;

import com.island.interview.singleton.Singleton4;

import java.util.concurrent.*;

/**
 * @author island
 * @version 1.0 2021/6/21 20:33
 */
public class Singleton4Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
/*        Singleton4 instance = Singleton4.getInstance();
        Singleton4 instance2 = Singleton4.getInstance();

        System.out.println(instance == instance2);
        System.out.println(instance);
        System.out.println(instance2);*/

        // 可能存在线程安全问题

        Callable<Singleton4> callable = new Callable<Singleton4>() {
            @Override
            public Singleton4 call() throws Exception {
                return Singleton4.getInstance();
            }
        };

        ExecutorService ex = Executors.newFixedThreadPool(2);
        Future<Singleton4> future1 = ex.submit(callable);
        Future<Singleton4> future2 = ex.submit(callable);
        Singleton4 instance = future1.get();
        Singleton4 instance2 = future2.get();
        System.out.println(instance == instance2);
        System.out.println(instance);
        System.out.println(instance2);
        ex.shutdown();

    }
}
