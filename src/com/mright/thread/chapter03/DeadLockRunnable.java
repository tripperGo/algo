package com.mright.thread.chapter03;

/**
 * @author: mright
 * @date: Created in 2020/4/26 9:49 PM
 * @desc:
 */
public class DeadLockRunnable implements Runnable {

    private int flag;

    private static Object obj1 = new Object();
    private static Object obj2 = new Object();

    public DeadLockRunnable(int flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag == 1) {
            synchronized (obj1) {
                System.out.println(Thread.currentThread().getName() + "已获取到obj1，等待obj2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2) {
                    System.out.println(Thread.currentThread().getName() + "已获取到obj1和obj2");
                }
            }
        } else {
            synchronized (obj2) {
                System.out.println(Thread.currentThread().getName() + "已获取到obj2，等待obj1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj1) {
                    System.out.println(Thread.currentThread().getName() + "已获取到obj1和obj2");
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLockRunnable dead1 = new DeadLockRunnable(1);
        DeadLockRunnable dead2 = new DeadLockRunnable(2);

        Thread t1 = new Thread(dead1, "线程一");
        Thread t2 = new Thread(dead2, "线程二");

        t1.start();
        t2.start();
    }
}
