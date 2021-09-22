package com.island.interview.queue;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author island
 * @version 1.0 2021/9/21 20:30
 */

class MyProdConsumer{

    private volatile boolean FLAG = true; // 默认开启 进行生产和消费
    private  AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue = null;

    public MyProdConsumer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProd() throws InterruptedException {

        while (FLAG){
            int data = atomicInteger.incrementAndGet();
            // 将元素放入阻塞队列中
            boolean retValue = blockingQueue.offer(String.valueOf(data),2, TimeUnit.SECONDS);
            if (retValue){
                System.out.println(Thread.currentThread().getName() + "\t" + "插入队列 " + data + "成功");
            }else{
                System.out.println(Thread.currentThread().getName() + "\t" + "插入队列 " + data + "失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println(Thread.currentThread().getName() + "\t" + "大老板叫停");
    }

    public void myCosumer() throws InterruptedException {

        while (FLAG){
            String result = blockingQueue.poll(2,TimeUnit.SECONDS);
            if (Objects.isNull(result)){
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t" + "超过两秒钟没有取到元素");
                return;

            }
            System.out.println(Thread.currentThread().getName() + "\t" + "取出队列 " + result + "成功");
        }
    }

    public void stop(){

        this.FLAG = false;
    }
}

public class BlockQueueProdCosumer {

    public static void main(String[] args) throws InterruptedException {
        MyProdConsumer myProdConsumer = new MyProdConsumer(new ArrayBlockingQueue<>(10));

        new Thread(() -> {
            try {
                myProdConsumer.myProd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"prod").start();


        new Thread(() -> {
            try {
                myProdConsumer.myCosumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"consumer").start();


        TimeUnit.SECONDS.sleep(5);
        myProdConsumer.stop();

    }

}
