package com.mright.thread.chapter01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: mright
 * @date: Created in 2020/4/23 9:34 PM
 * @desc:
 */
public class MyExecutor {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new MyThread());

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " 线程 ==> " + i);
        }
    }
}
