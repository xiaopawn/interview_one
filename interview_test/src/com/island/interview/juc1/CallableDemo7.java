package com.island.interview.juc1;

import java.util.concurrent.*;

class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " hello Callable");
        return 1024;
    }
}
/**
 * @author island
 * @version 1.0 2021/7/17 19:48
 */
public class CallableDemo7 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());

        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();
        Integer integer = futureTask.get();

        System.out.println(integer);
    }

}
