package com.mright.algo.chapter06;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/7/2 10:10
 */
public class Client {

    public static void main(String[] args) {
        PersonService service = new PersonService();
        PersonProxy personProxy = new PersonProxy(service);

        personProxy.say();
        personProxy.sleep();
    }
}
