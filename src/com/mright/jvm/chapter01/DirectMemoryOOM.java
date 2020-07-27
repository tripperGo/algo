package com.mright.jvm.chapter01;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/7/23 14:48
 */
public class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
