package com.mright.jvm.chapter02;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/7/23 15:01
 */
public class ReferenceCountingGC {

    public Object instance = null;
    private static final int _1MB = 1024 * 1024;
    /**
     * 这个成员属性的唯一意义就是占点内存， 以便能在GC日志中看清楚是否有回收过
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
        // 假设在这行发生GC， objA和objB是否能被回收？
        System.gc();
    }

    public static void main(String[] args) {
        for(int i = 0; i < 20; i++){

            System.out.println(Fibonacci(i));
        }
    }

    public static int Fibonacci(int n) {
        int i = 1, j = 1;
        if(n == 0){
            return 0;
        }
        if(n <= 2){
            return 1;
        }

        for(int m = 3; m <= n; m++){
            int temp = j;
            j = i + j;
            i = temp;
        }

        return j;
    }
}
