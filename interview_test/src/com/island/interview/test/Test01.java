package com.island.interview.test;

/**
 * @author island
 * @version 1.0 2021/6/20 21:32
 */
public class Test01 {

    public static void main(String[] args) {
        int i = 1;
        i = i += 1;
        int j = i++;
        int k = i + ++i * i++;
        System.out.println("i=" + i);
        System.out.println("j=" + j);
        System.out.println("k=" + k);
    }


}
