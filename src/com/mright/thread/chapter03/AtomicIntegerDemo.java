package com.mright.thread.chapter03;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: mright
 * @date: Created in 2020/5/1 9:11 PM
 * @desc:
 */
public class AtomicIntegerDemo {

    //    private static int n;
    private static AtomicInteger n;

    public static void main(String[] args) throws InterruptedException {
        int count = 0;
        while (count++ < 100) {
//            n = 0;
            n = new AtomicInteger(0);
            Thread thread1 = new Thread(() -> {
                for (int i = 0; i++ < 1000; ) {
//                    n++;
                    n.getAndIncrement();
                }
            });

            Thread thread2 = new Thread(() -> {
                for (int i = 0; i++ < 1000; ) {
//                    n++;
                    n.getAndIncrement();
                }
            });

            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();

//            System.out.println(n);
            System.out.println(n.get());
        }
    }
}
