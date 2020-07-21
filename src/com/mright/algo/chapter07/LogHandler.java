package com.mright.algo.chapter07;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/7/2 10:50
 */
public class LogHandler implements InvocationHandler {

    private Object target;

    public LogHandler(Object object) {
        this.target = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    private void before() {
        System.out.println("方法执行之前的日志记录：" + new Date());
    }

    private void after() {
        System.out.println("方法执行之后的日志记录：" + new Date());
    }
}
