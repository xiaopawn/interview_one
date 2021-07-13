package com.island.interview.test2;

/**
 * @author island
 * @version 1.0 2021/6/26 21:06
 */
public class GrandFather {
    private int i = test();
    private static int j = method();

    static{
        System.out.print("(11)");
    }
    GrandFather() {
        System.out.print("(12)");
    }
    {
        System.out.print("(13)");
    }
    public int test(){
        System.out.print("(14)");
        return 1;
    }
    public static int method() {
        System.out.print("(15)");
        return 1;
    }
}
