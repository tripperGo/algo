package com.mright.algo.chapter06;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/7/2 10:08
 */
public class PersonProxy implements IPerson {

    private IPerson target;

    public PersonProxy(IPerson person) {
        this.target = person;
    }

    @Override
    public void say() {
        this.before();
        target.say();
        this.after();
    }

    @Override
    public void sleep() {
        this.before();
        target.sleep();
        this.after();
    }

    private void before() {
        System.out.println("增强日志，记录方法执行之前的日志。。。");
    }

    private void after() {
        System.out.println("增强日志，记录方法执行之后的日志。。。");
    }
}
