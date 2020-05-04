package com.mright.thread.chapter04;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: mright
 * @date: Created in 2020/5/1 11:16 PM
 * @desc: 可重入锁
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        for (int i = 1; i <= 10; i++) {
            lock.lock();
            System.out.println("加锁次数：" + i);
        }

        for (int i = 1; i <= 10; i++) {
            try {
                System.out.println("解锁次数：" + i);
            } finally {
                lock.unlock();
            }
        }
    }
}
