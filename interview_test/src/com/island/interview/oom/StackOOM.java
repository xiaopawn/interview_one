package com.island.interview.oom;

/**
 * @author island
 * @version 1.0 2022/3/17 12:07
 */
public class StackOOM {

    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        StackOOM stackOOM = new StackOOM();
        try {
            stackOOM.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + stackOOM.stackLength);
            e.printStackTrace();
        }
    }
}
