package com.island.interview.singletontest;

import com.island.interview.singleton.Singleton5;
import com.island.interview.singleton.Singleton6;

import java.util.concurrent.*;

/**
 * @author island
 * @version 1.0 2021/6/21 20:33
 */
public class Singleton6Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Singleton6 instance = Singleton6.getInstance();
        Singleton6 instance2 = Singleton6.getInstance();
        System.out.println(instance == instance2);
        System.out.println(instance);
        System.out.println(instance2);

    }
}
