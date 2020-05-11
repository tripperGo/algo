package com.mright.algo.chapter03;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/5/9 15:39
 */
public class ReflectClass {

    private final static String TAG = "peter.log.ReflectClass";

    /**
     * 创建对象
     */
    public static void reflectNewInstance() {
        try {
            Class<?> classBook = Class.forName("com.mright.algo.chapter03.Book");
            Object objectBook = classBook.newInstance();
            Book book = (Book) objectBook;
            book.setName("Java从入门到放弃");
            book.setAuthor("赵传真");
            System.out.println("reflectNewInstance Book = " + book.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 反射私有构造器
     */
    public static void reflectPrivateConstructor() {
        try {
            Class<?> classBook = Class.forName("com.mright.algo.chapter03.Book");
            Constructor<?> declaredConstructor = classBook.getDeclaredConstructor(String.class, String.class);
            declaredConstructor.setAccessible(true);
            Object objectBook = declaredConstructor.newInstance("Java从入门到放弃", "赵传真");
            Book book = (Book) objectBook;
            System.out.println("reflectConstructor book = " + book.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 反射私有属性
     */
    public static void reflectPrivateField() {
        try {
            Class<?> classBook = Class.forName("com.mright.algo.chapter03.Book");
            Object objectBook = classBook.newInstance();
            Field fieldTag = classBook.getDeclaredField("TAG");
            fieldTag.setAccessible(true);
            String tag = (String) fieldTag.get(objectBook);
            System.out.println("reflectPrivateField tag = " + tag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 反射私有方法
     */
    public static void reflectPrivateMethod() {
        try {
            Class<?> classBook = Class.forName("com.mright.algo.chapter03.Book");
            Method methodBook = classBook.getDeclaredMethod("declaredMethod", int.class);
            methodBook.setAccessible(true);
            Object objectBook = classBook.newInstance();
            String str = (String) methodBook.invoke(objectBook, 0);
            System.out.println("reflectPrivateMethod str = " + str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        reflectNewInstance();
        reflectPrivateConstructor();
        reflectPrivateField();
        reflectPrivateMethod();
    }
}
