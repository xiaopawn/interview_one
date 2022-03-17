package com.island.interview.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author island
 * @version 1.0 2022/3/17 12:51
 */
public class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) throws IllegalAccessException {
        Field unSafeField = Unsafe.class.getDeclaredFields()[0];
        unSafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unSafeField.get(null);
        while (true){
            unsafe.allocateMemory(_1MB);
        }
    }
}
