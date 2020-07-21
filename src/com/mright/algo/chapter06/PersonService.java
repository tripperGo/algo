package com.mright.algo.chapter06;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/7/2 10:07
 */
public class PersonService implements IPerson {
    @Override
    public void say() {
        System.out.println("吃饭~~");
    }

    @Override
    public void sleep() {
        System.out.println("睡觉~~");
    }
}
