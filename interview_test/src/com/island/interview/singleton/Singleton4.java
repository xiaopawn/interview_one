package com.island.interview.singleton;

/**
 * @author island
 * @version 1.0 2021/6/21 20:15
 */
public class Singleton4 {

    private static Singleton4 instance;

    private Singleton4(){}

    public static Singleton4 getInstance(){

        if (instance == null){
            instance = new Singleton4();
        }
        return instance;
    }
}
