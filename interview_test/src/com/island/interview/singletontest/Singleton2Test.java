package com.island.interview.singletontest;

import com.island.interview.singleton.Singleton2;

/**
 * @author island
 * @version 1.0 2021/6/21 19:41
 */
public class Singleton2Test {

    public static void main(String[] args) {
        Singleton2 instance = Singleton2.INSTANCE;
        System.out.println(instance);
    }
}
