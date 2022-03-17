package com.island.interview.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author island
 * @version 1.0 2022/3/17 12:18
 */
public class RunTimeContantPoolOOM {
    public static void main(String[] args) {

        // 设置永久代需要在java1.6之前  降低jdk版本 此代码会报错。
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
