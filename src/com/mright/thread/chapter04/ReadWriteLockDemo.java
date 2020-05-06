package com.mright.thread.chapter04;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: mright
 * @date: Created in 2020/5/1 11:29 PM
 * @desc:
 */
public class ReadWriteLockDemo {

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
    Map<String, String> map = new HashMap<>();

    public String get(String key) {
        readLock.lock();
        System.out.println(Thread.currentThread().getName() + "正在执行读操作。。。");
        try {
            Thread.sleep(3000);
            return map.get(key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
            System.out.println(Thread.currentThread().getName() + "读操作执行完毕");
        }
        return "";
    }

    public void set(String key, String value) {
        writeLock.lock();
        System.out.println(Thread.currentThread().getName() + "正在执行写操作。。。");
        try {
            Thread.sleep(3000);
            map.put(key, value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
            System.out.println(Thread.currentThread().getName() + "写操作执行完毕");
        }
    }

    public static void main(String[] args) {
        ReadWriteLockDemo demo = new ReadWriteLockDemo();
        demo.set("str", "1111aaaa");
        new Thread("读线程1") {
            @Override
            public void run() {
                System.out.println(demo.get("str"));
            }
        }.start();
        new Thread("读线程2") {
            @Override
            public void run() {
                System.out.println(demo.get("str"));
            }
        }.start();
        new Thread("读线程3") {
            @Override
            public void run() {
                System.out.println(demo.get("str"));
            }
        }.start();
    }
}
