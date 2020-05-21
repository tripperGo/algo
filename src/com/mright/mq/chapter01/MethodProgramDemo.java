package com.mright.mq.chapter01;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author : zhaochuanzhen
 * @description : 函数式编程
 * @date : 2020/5/21 14:08
 */
public class MethodProgramDemo {

    public static void main(String[] args) {
        test4();
    }

    /**
     * 函数式接口，Function。可以用lambda表达式简化
     */
    public static void test1() {
        /*Function<String, String> function = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s;
            }
        };

        System.out.println(function.apply("test"));*/

        Function<String, String> function = (str) -> str;
        System.out.println(function.apply("test"));
    }

    /**
     * 断言型接口
     */
    public static void test2() {
        Predicate<String> ss = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        };
        System.out.println(ss.test("ss"));

        Predicate<String> s = s1 -> false;
        System.out.println(s.test("ss"));
    }

    /**
     * 消费型接口
     */
    public static void test3() {
/*        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };

        consumer.accept(1);*/

        Consumer<Integer> consumer = System.out::println;
        consumer.accept(11);
    }

    /**
     * 供给型接口
     */
    public static void test4() {
/*        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "success";
            }
        };
        System.out.println(supplier.get());*/

        Supplier<String> supplier = () -> "success";
        System.out.println(supplier.get());
    }
}
