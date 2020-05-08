package com.mright.algo.chapter02;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/5/7 10:23
 */
class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(int data) {
        this.data = data;
    }

    public Node() {
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setChild(Node left, Node right) {
        this.left = left;
        this.right = right;
    }
}