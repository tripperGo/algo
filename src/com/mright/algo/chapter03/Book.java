package com.mright.algo.chapter03;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/5/9 15:36
 */
public class Book {
    private final static String TAG = "BookTag";

    private String name;
    private String author;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public Book() {
    }

    private Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    private String declaredMethod(int index) {
        String string;
        switch (index) {
            case 1:
                string = "I am declaredMethod 2 !";
                break;
            case 0:
            default:
                string = "I am declaredMethod 1 !";
                break;
        }

        return string;
    }
}
