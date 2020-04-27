package com.mright.thread.chapter03;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/4/27 9:49
 */
public class CyclicBarrierDemo {

    private final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    public void exepute() {
        String name = Thread.currentThread().getName();
        System.out.println(name + "正在准备......" + System.currentTimeMillis());
        try {
            cyclicBarrier.await();
            System.out.println(name + "已经准备完毕，" + System.currentTimeMillis());
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CyclicBarrierDemo demo = new CyclicBarrierDemo();
        new Thread("线程一") {
            @Override
            public void run() {
                demo.exepute();
            }
        }.start();

        new Thread("线程二") {
            @Override
            public void run() {
                demo.exepute();
            }
        }.start();

        new Thread("线程三") {
            @Override
            public void run() {
                demo.exepute();
            }
        }.start();
    }
}
