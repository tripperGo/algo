package com.mright.jvm.chapter02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/8/6 10:38
 */
public class PersonProxy implements InvocationHandler {

    private Object target;

    public PersonProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    private void after(){
        System.out.println("调用方法之后的处理~~");
    }

    private void before(){
        System.out.println("调用方法之前的处理~~");
    }
}
