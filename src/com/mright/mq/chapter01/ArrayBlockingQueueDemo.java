package com.mright.mq.chapter01;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/5/21 9:40
 */
public class ArrayBlockingQueueDemo {

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
        test4();
    }

    /**
     * 抛出异常
     */
    public static void test1() {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
        System.out.println(queue.add(1));
        System.out.println(queue.add(2));
        System.out.println(queue.add(3));
//        System.out.println(queue.add(4));

        System.out.println("====================");

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.element());
//        System.out.println(queue.remove());
    }

    /**
     * 返回布尔值，不抛出异常
     */
    public static void test2() {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
        System.out.println(queue.offer(1));
        System.out.println(queue.offer(2));
        System.out.println(queue.offer(3));
        System.out.println(queue.offer(4));

        System.out.println("=================");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
    }

    /**
     * 阻塞、等待
     */
    public static void test3() {
        try {
            ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
            queue.put(1);
            queue.put(2);
            queue.put(3);
//            queue.put(4);
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
//            System.out.println(queue.take());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 超时、等待
     */
    public static void test4() {
        try {
            ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
            System.out.println(queue.offer(1, 2, TimeUnit.SECONDS));
            System.out.println(queue.offer(2, 2, TimeUnit.SECONDS));
            System.out.println(queue.offer(3, 2, TimeUnit.SECONDS));
            System.out.println(queue.offer(4, 2, TimeUnit.SECONDS));
            System.out.println(queue.poll(2, TimeUnit.SECONDS));
            System.out.println(queue.poll(2, TimeUnit.SECONDS));
            System.out.println(queue.poll(2, TimeUnit.SECONDS));
            System.out.println(queue.poll(2, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
