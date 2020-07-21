package com.mright.algo.chapter07;

import java.lang.reflect.Proxy;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/7/2 10:53
 */
public class Client {

    public static void main(String[] args) {
        PersonService personService = new PersonService();
        LogHandler handler = new LogHandler(personService);

        IPerson proxy = (IPerson) Proxy.newProxyInstance(personService.getClass().getClassLoader(),
                personService.getClass().getInterfaces(),
                handler);

        proxy.say();
        proxy.sleep();

        ProxyUtils.generateClassFile(personService.getClass(), "PersonProxy");
    }
}
