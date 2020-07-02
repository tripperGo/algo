package com.mright.algo.chapter04;

/**
 * @author : zhaochuanzhen
 * @description : 静态代理 客户端
 * @date : 2020/6/18 14:04
 */
public class Client {

    public static void main(String[] args) {
        UserService userServiceImpl = new UserServiceImpl();
        UserService proxy = new UserServiceProxy(userServiceImpl);

        proxy.select();
        proxy.update();
    }
}
