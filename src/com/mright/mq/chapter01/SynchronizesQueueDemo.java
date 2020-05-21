package com.mright.mq.chapter01;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/5/21 10:25
 */
public class SynchronizesQueueDemo {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new SynchronousQueue<>();

        new Thread("生产队列") {
            @Override
            public void run() {

                try {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(Thread.currentThread().getName() + " ==> 生产消息：" + i);
                        queue.put(i);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread("消费队列") {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println(Thread.currentThread().getName() + " ==> 消费消息：" + queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
