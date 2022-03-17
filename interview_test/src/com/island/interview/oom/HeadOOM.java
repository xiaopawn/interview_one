package com.island.interview.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author island
 * @version 1.0 2022/3/16 12:40
 */
public class HeadOOM {

    static class OOMObject{}
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
