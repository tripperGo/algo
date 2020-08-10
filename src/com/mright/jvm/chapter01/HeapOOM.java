package com.mright.jvm.chapter01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/7/23 11:17
 */
public class HeapOOM {

    public static void main(String[] args) {
        List<HeapOOM> list = new ArrayList<>();
        while (true) {
            list.add(new HeapOOM());
        }
    }
}
