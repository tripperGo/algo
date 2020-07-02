package com.mright.algo.chapter05;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/6/19 14:29
 */
public class StudentProxy {

    public static void main(String[] args) {
        IStudent student = new Pupil();
        student.eat();
        student.write();

        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();

                Object result = method.invoke(student, args);

                if ("eat".equals(methodName)) {
                    System.out.println("我在吃汉堡、牛排！");
                }

                if ("write".equals(methodName)) {
                    System.out.println("我的作文题目是《我的区长父亲》！");
                }
                return result;
            }
        };

        IStudent goodStudent = (IStudent) Proxy.newProxyInstance(student.getClass().getClassLoader(), student.getClass().getInterfaces(), handler);
        goodStudent.eat();
        goodStudent.write();

        // 保存JDK动态代理生成的代理类，类名保存为 UserServiceProxy
        ProxyUtils.generateClassFile(student.getClass(), "studentProxy");

    }
}
