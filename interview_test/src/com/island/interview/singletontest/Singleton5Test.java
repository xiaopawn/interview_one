package com.island.interview.singletontest;

import com.island.interview.singleton.Singleton5;

import java.util.concurrent.*;

/**
 * @author island
 * @version 1.0 2021/6/21 20:33
 */
public class Singleton5Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        Callable<Singleton5> callable = new Callable<Singleton5>() {
            @Override
            public Singleton5 call() throws Exception {
                return Singleton5.getInstance();
            }
        };

        ExecutorService ex = Executors.newFixedThreadPool(2);
        Future<Singleton5> future1 = ex.submit(callable);
        Future<Singleton5> future2 = ex.submit(callable);
        Singleton5 instance = future1.get();
        Singleton5 instance2 = future2.get();
        System.out.println(instance == instance2);
        System.out.println(instance);
        System.out.println(instance2);
        ex.shutdown();

    }
}
