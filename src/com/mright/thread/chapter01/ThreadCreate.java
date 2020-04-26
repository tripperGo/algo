package com.mright.thread.chapter01;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: mright
 * @date: Created in 2020/4/23 9:13 PM
 * @desc:
 */
public class ThreadCreate {

    public static void main(String[] args) {
        // 子线程
        FutureTask<String> task = new FutureTask<>(new MyCallable());
        Thread thread = new Thread(task, "子线程1");
        thread.start();

        // 主线程
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " 线程 ==> " + i);
        }

        try {
            System.out.println(task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
