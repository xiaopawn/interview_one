package com.island.interview.test5;

/**
 * @author island
 * @version 1.0 2021/7/4 19:42
 */
public class LocalAndMemberVariable {


    public static int s;
    int i;
    int j;

    {
        int i = 1;
        i++;
        j++;
        s++;
    }

    public void test(int j) {
        j++;
        i++;
        s++;
    }

    public static void main(String[] args) {
        LocalAndMemberVariable obj1 = new LocalAndMemberVariable();
        LocalAndMemberVariable obj2 = new LocalAndMemberVariable();

        obj1.test(10);
        obj1.test(20);
        obj2.test(30);

        System.out.println(obj1.i + "," + obj1.j + "," + obj1.s);
        System.out.println(obj2.i + "," + obj2.j + "," + obj2.s);
    }

}
