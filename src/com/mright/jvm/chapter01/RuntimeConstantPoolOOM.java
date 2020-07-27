package com.mright.jvm.chapter01;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/7/23 14:35
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        /*Set<String> set = new HashSet<>();
        short i = 0;
        while (true) {
            set.add(String.valueOf(i).intern());
        }*/

        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
