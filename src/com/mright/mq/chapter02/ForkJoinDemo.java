package com.mright.mq.chapter02;

import java.util.concurrent.ForkJoinPool;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/5/21 15:21
 */
public class ForkJoinDemo {

    public static void main(String[] args) {
        test1();
    }

    /**
     * 低效率累加运算
     */
    public static void test1() {
        int sum = 0;
        for (int i = 0; i < 10000; i++) {
            sum += i;
        }

        System.out.println(sum);
    }

    public static void test2() {
        ForkJoinPool s = new ForkJoinPool();
    }
}
