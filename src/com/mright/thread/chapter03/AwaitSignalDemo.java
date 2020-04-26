package com.mright.thread.chapter03;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: mright
 * @date: Created in 2020/4/26 11:08 PM
 * @desc:
 */
public class AwaitSignalDemo {

    private int i = 0;
    private Lock lock = new ReentrantLock(false);
    private Condition condition = lock.newCondition();

    public void odd() throws InterruptedException {
        while (i < 10) {
            lock.lock();
            try {
                if (i % 2 == 1) {
                    System.out.println("奇数" + i++);
                    condition.signal();
                } else {
                    condition.await();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void even() throws InterruptedException {
        while (i < 10) {
            lock.lock();
            try {
                if (i % 2 == 0) {
                    System.out.println("偶数" + i++);
                    condition.signal();
                } else {
                    condition.await();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final AwaitSignalDemo demo = new AwaitSignalDemo();

        new Thread(() -> {
            try {
                demo.odd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                demo.even();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
