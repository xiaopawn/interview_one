package com.island.interview.singleton;

/**
 * @author island
 * @version 1.0 2021/6/21 23:04
 */


/**
 * 用内部类的方式能够保证线程安全 因为用了类加载器 同时能够保证延迟加载
 */

public class Singleton6 {


    private Singleton6(){}

    private static class Inner{
        private static final Singleton6 INSTANCE = new Singleton6();
    }

    public static Singleton6 getInstance(){
        return Inner.INSTANCE;
    }
}
