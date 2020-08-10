package com.mright.jvm.chapter02;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/8/6 10:38
 */
public class PersonServiceImpl implements IPersonService {
    @Override
    public void say() {
        System.out.println("说话~~~");
    }

    @Override
    public void sleep() {
        System.out.println("睡睡~~~");
    }
}
