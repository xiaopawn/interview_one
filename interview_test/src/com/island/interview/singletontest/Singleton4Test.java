package com.island.interview.singletontest;

import com.island.interview.singleton.Singleton4;

/**
 * @author island
 * @version 1.0 2021/6/21 20:33
 */
public class Singleton4Test {
    public static void main(String[] args) {
        Singleton4 instance = Singleton4.getInstance();
        Singleton4 instance2 = Singleton4.getInstance();

        System.out.println(instance == instance2);
        System.out.println(instance);
        System.out.println(instance2);

    }
}
