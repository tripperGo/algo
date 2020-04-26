package com.mright.thread.chapter02;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: mright
 * @date: Created in 2020/4/25 12:54 PM
 * @desc:
 */
public class Ticket implements Runnable {
    private int ticketNum = 100;

    Lock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (ticketNum > 0) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " 线程销售了电影票：" + ticketNum--);
                }
            } catch (InterruptedException e) {
                                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
