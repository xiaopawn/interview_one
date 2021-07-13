package com.island.interview.test2;

/**
 * 子类的初始化<clinit>
 * 1、j = method()
 * 2、子类的静态代码块
 *
 * 先初始化父类 (5)(1)
 * 初始化子类 (10) (6)
 *
 * 子类实例化方法:
 * 1、super()（最前
 * 2、i = test() (9)
 * 3、子类的非静态代码块 (8)
 * 4、子类的无参构造（最后）(7)
 */

public class Son extends Father {
    private int i = test();
    private static int j = method();
    static {
        System.out.print("(6)");
    }
    Son() {
        System.out.print("(7)");
    }
    {
        System.out.print("(8)");
    }
    public int test(){
        System.out.print("(9)");
        return 1;
    }
    public static int method() {
        System.out.print("(10)");
        return 1;
    }

    public static void main(String[] args) {
        Son son = new Son(); // 15 11 5 1 10 6
        System.out.println();
        Son son1 = new Son();
    }
}
