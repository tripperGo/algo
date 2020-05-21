package com.mright.mq.chapter02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author : zhaochuanzhen
 * @description : 流式计算--lambda
 * @date : 2020/5/21 14:58
 */
public class StreamDemo {

    public static void main(String[] args) {
        test1();
    }

    /**
     * 1、ID必须是偶数
     * 2、年龄必须大于23岁
     * 3、用户名转为大写
     * 4、用户名字母倒叙排
     * 5、只输出一个用户
     */
    public static void test1() {
        User user1 = new User(1, 21, "a");
        User user2 = new User(2, 22, "b");
        User user3 = new User(3, 23, "c");
        User user4 = new User(4, 24, "d");
        User user5 = new User(5, 25, "e");
        User user6 = new User(6, 26, "f");

        List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6);

        list.stream()
                .filter(u -> u.getId() % 2 == 0)
                .filter(u -> u.getAge() > 23)
                .map(u -> u.getName().toUpperCase())
                .sorted(Comparator.reverseOrder())
                .limit(1)
                .forEach(System.out::println);
    }
}
