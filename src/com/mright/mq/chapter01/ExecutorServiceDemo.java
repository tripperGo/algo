package com.mright.mq.chapter01;

import java.util.concurrent.*;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/5/21 10:46
 */
public class ExecutorServiceDemo {

    public static void main(String[] args) {
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
//        ExecutorService threadPool = Executors.newFixedThreadPool(3);
//        ExecutorService threadPool = Executors.newCachedThreadPool();

        ExecutorService threadPool = new ThreadPoolExecutor(2,
                Runtime.getRuntime().availableProcessors(),
                2,
                TimeUnit.HOURS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        try {
            for (int i = 0; i < 9; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " ok");
                });
            }
        } finally {
            threadPool.shutdown();
        }
    }
}
