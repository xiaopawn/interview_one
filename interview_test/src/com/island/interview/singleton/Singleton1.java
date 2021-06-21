package com.island.interview.singleton;

/**
 * @author island
 * @version 1.0 2021/6/21 19:31
 */

/**
 * 饿汉式
 *  在类初始化时 直接创建实例对象 不管你需不需要这个对象。
 *
 * 1、构造器私有化
 * 2、自行创建，并且用静态变量保存
 * 3、向外提供实例 定义为静态
 * 4、强调这是一个单例，我们可以用final修改
 */
public class Singleton1 {

    public static final Singleton1 INSTANCE = new Singleton1();
    private Singleton1(){}
}
