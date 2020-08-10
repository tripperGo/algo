package com.mright.jvm.chapter02;

import java.lang.reflect.Proxy;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/8/6 10:42
 */
public class Client {

    public static void main(String[] args) {
        IPersonService iPersonService = new PersonServiceImpl();
        PersonProxy proxy = new PersonProxy(iPersonService);
        IPersonService iPerson = (IPersonService) Proxy.newProxyInstance(iPersonService.getClass().getClassLoader(), iPersonService.getClass().getInterfaces(), proxy);
        iPerson.say();
        iPerson.sleep();
    }
}
