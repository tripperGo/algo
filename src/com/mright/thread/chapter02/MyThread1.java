package com.mright.thread.chapter02;

/**
 * @author: mright
 * @date: Created in 2020/4/25 12:56 PM
 * @desc:
 */
public class MyThread1 {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);
        t1.start();
        t2.start();
        t3.start();
    }
}
