package com.mright.mq.chapter01;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
//        test1();
//        test2();
//        test3();
        test4();
    }

    /**
     * 阻塞队列--抛出异常
     */
    public static void test1() {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
        System.out.println(queue.add(1));
        System.out.println(queue.add(2));
        System.out.println(queue.add(3));
//        System.out.println(queue.add(4));

        System.out.println("==========================");
//        System.out.println(queue.remove(3));
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.element());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
    }

    /**
     * 阻塞队列--返回false
     */
    public static void test2() {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
        System.out.println(queue.offer(1));
        System.out.println(queue.offer(2));
        System.out.println(queue.offer(3));
//        System.out.println(queue.offer(4)); // 返回false

        System.out.println("===============================");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
    }

    /**
     * 阻塞，等待
     *
     * @throws InterruptedException e
     */
    public static void test3() throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
        queue.put(1);
        queue.put(2);
        queue.put(3);
//        queue.put(4);

        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
    }

    /**
     * 则色，超时等待
     *
     * @throws InterruptedException e
     */
    public static void test4() throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
        System.out.println(queue.offer(1, 1, TimeUnit.SECONDS));
        System.out.println(queue.offer(2, 1, TimeUnit.SECONDS));
        System.out.println(queue.offer(3, 1, TimeUnit.SECONDS));
        System.out.println(queue.offer(4, 2, TimeUnit.SECONDS));

        System.out.println(queue.poll());
    }
}
