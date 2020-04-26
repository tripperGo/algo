package com.mright.thread.chapter03;

/**
 * @author: mright
 * @date: Created in 2020/4/26 11:00 PM
 * @desc:
 */
public class WaitNotifyDemo {

    private int i = 0;
    private Object obj = new Object();

    public void odd() {
        while (i < 10) {
            synchronized (obj) {
                if (i % 2 == 1) {
                    System.out.println("奇数" + i++);
                    obj.notify();
                } else {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void Even() {
        while (i < 10) {
            synchronized (obj){
                if (i % 2 == 0) {
                    System.out.println("偶数" + i++);
                    obj.notify();
                } else {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        WaitNotifyDemo demo = new WaitNotifyDemo();
        new Thread(() -> demo.odd()).start();

        new Thread(() -> demo.Even()).start();
    }
}
