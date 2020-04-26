package com.mright.thread.chapter01;

/**
 * @author: mright
 * @date: Created in 2020/4/23 9:36 PM
 * @desc:
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " 线程 ==> " + i);
        }
    }
}
