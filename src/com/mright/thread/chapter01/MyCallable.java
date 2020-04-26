package com.mright.thread.chapter01;

import java.util.concurrent.Callable;

/**
 * @author: mright
 * @date: Created in 2020/4/23 9:15 PM
 * @desc:
 */
public class MyCallable implements Callable<String> {

    @Override
    public String call() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " 线程 ==> " + i);
        }
        return Thread.currentThread().getName() + " 线程执行完毕！！！";
    }
}
