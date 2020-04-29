package com.mright.thread.chapter03;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: mright
 * @date: Created in 2020/4/29 8:04 AM
 * @desc:
 */
public class AtomicDemo {
    private static AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        int num = 0;
        while (++num < 100) {
            count.set(0);
            Thread t1 = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    count.addAndGet(1);
                }
            });
            Thread t2 = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    count.addAndGet(1);
                }
            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();
            if (count.get() != 2000) {
                System.out.println("==============================" + count);
            } else {
                System.out.println(count);
            }
        }
    }
}
