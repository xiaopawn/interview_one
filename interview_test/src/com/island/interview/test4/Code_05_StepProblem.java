package com.island.interview.test4;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Code_05_StepProblem {

    public void test() {
        // 时间复杂度 ...
//        long start = System.currentTimeMillis();
//        System.out.println(recursion(4)); // 165580141
//        long end = System.currentTimeMillis(); // 537
//        System.out.println(end - start);

        // 时间复杂度 O(n)
        long start = System.currentTimeMillis();
        System.out.println(iteration(40)); // 165580141
        long end = System.currentTimeMillis(); // 0
        System.out.println(end - start);

        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
    }

    // 递归实现
    public int recursion(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        return recursion(n - 2) + recursion(n - 1);
    }

    // 迭代实现
    public int iteration(int n) {
        if(n < 1) {
            return 0;
        }
        if(n == 1 || n == 2) {
            return n;
        }
        int two = 1; // 一层台阶，有 1 走法, n 的前两层台阶的走法
        int one = 2; // 二层台阶，有 2 走法, n 的前一层台阶的走法
        int sum = 0; // 记录一共有多少中走法
        for(int i = 3; i <= n; i++) {
            sum = two + one;
            two = one;
            one = sum;
        }
        return sum;
    }
}