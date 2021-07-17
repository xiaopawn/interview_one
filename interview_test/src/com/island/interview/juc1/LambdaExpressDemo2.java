package com.island.interview.juc1;

/**
 * @author island
 * @version 1.0 2021/7/15 17:20
 */
// 显示的声明函数式接口
@FunctionalInterface
interface Poo {
//    void sayHello();

    int add(int x, int y);

    //声明和实现
    default int mull(int x, int y) {
        return x * y;
    }

    static int div(int x, int y) {
        return x / y;
    }
}

public class LambdaExpressDemo2 {

    public static void main(String[] args) {
       /* Poo poo = new Poo() {
            @Override
            public void sayHello() {
                System.out.println("sayHello 匿名内部类");
            }
        };

        poo.sayHello();*/
        Poo poo = (x, y) -> {
            System.out.println(x + y);
            return x + y;
        };

        poo.add(1, 3);

        System.out.println(poo.mull(2, 5));

        System.out.println(Poo.div(10, 5));
    }

}
