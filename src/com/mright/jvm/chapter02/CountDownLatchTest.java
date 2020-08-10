package com.mright.jvm.chapter02;

import java.util.concurrent.CountDownLatch;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/8/5 17:35
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(4);

        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " -- 执行");
                    latch.countDown();
                }
            }).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程执行");
    }
}
