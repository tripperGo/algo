package com.mright.thread.chapter03;

import java.util.concurrent.CountDownLatch;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/4/27 9:32
 */
public class CountDownLatchDemo {

    private final CountDownLatch countDownLatch = new CountDownLatch(3);

    /**
     * 运动员线程执行逻辑
     */
    public void sporter() {
        String name = Thread.currentThread().getName();
        System.out.println(name + "正在准备......");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "已经准备完毕！");
        countDownLatch.countDown();
    }

    /**
     * 教练线程执行逻辑
     */
    public void coach() {
        String name = Thread.currentThread().getName();
        System.out.println(name + "正在准备......");
        try {
            Thread.sleep(500);
            System.out.println(name + "等待运动员准备完成~~~");
            countDownLatch.await();
            System.out.println("所有运动员准备完毕，" + name + "打枪起跑！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CountDownLatchDemo demo = new CountDownLatchDemo();
        new Thread("教练") {
            @Override
            public void run() {
                demo.coach();
            }
        }.start();

        new Thread("运动员1") {
            @Override
            public void run() {
                demo.sporter();
            }
        }.start();

        new Thread("运动员2") {
            @Override
            public void run() {
                demo.sporter();
            }
        }.start();

        new Thread("运动员3") {
            @Override
            public void run() {
                demo.sporter();
            }
        }.start();
    }
}
