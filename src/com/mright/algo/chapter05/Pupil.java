package com.mright.algo.chapter05;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/6/19 14:28
 */
public class Pupil implements IStudent {
    @Override
    public void eat() {
        System.out.println("我在吃饭！");
    }

    @Override
    public void write() {
        System.out.println("我在写作文！");
    }
}
