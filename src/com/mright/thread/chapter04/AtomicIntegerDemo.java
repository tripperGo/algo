package com.mright.thread.chapter04;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/4/29 10:15
 */
public class AtomicIntegerDemo {

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        while (++i < 1000) {
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; ++j < 1000; ) {
                        count++;
                        System.out.println(count);
                    }
                }
            });
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; ++j < 1000; ) {
                        count++;
                        System.out.println(count);
                    }
                }
            });

            t2.start();
            t1.start();
            t1.join();
            t2.join();
        }
    }
}
