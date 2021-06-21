package com.island.interview.singletontest;

import com.island.interview.singleton.Singleton1;

/**
 * @author island
 * @version 1.0 2021/6/21 19:40
 */
public class Singleton1Test {

    public static void main(String[] args) {
        Singleton1 instance = Singleton1.INSTANCE;
        System.out.println(instance);
    }
}
