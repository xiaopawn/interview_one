package com.island.interview.cas;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author island
 * @version 1.0 2021/8/21 21:33
 */

class User{
    private String name;
    private int age;
    private String idCard;

    public User(String name, int age, String idCard) {
        this.name = name;
        this.age = age;
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", idCard='" + idCard + '\'' +
                '}';
    }
}

public class AtomicReferenceDemo {

    public static void main(String[] args) {
        User zhangsan = new User("zhangsan", 12, "123");
        User lisi = new User("lisi", 18, "9527");
        AtomicReference<User> atomicReference = new AtomicReference<>(zhangsan);
        System.out.println(atomicReference.compareAndSet(zhangsan, lisi) + "\t" + " this current user " + atomicReference.get().toString());

    }
}
