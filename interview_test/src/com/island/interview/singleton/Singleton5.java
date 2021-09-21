package com.island.interview.singleton;

/**
 * @author island
 * @version 1.0 2021/6/21 20:15
 */
/*
* 线程安全 适用于多线程
* */
public class Singleton5 {

    private static Singleton5 instance;

    private Singleton5(){}

    public static Singleton5 getInstance(){

        // 这个if是为了优化 如果已经有了  双端检索DCL
        if (instance == null){
            synchronized (Singleton5.class){
                if (instance == null){
                    instance = new Singleton5();
                }
            }
        }

        return instance;
    }
}
