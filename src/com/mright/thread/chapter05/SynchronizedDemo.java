package com.mright.thread.chapter05;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/5/6 10:22
 */
public class SynchronizedDemo {

    public static void main(String[] args) {
        synchronized (SynchronizedDemo.class) {
        }
        method();
    }

    private static void method() {
    }
}
