package com.mright.algo.chapter01;

import java.util.Scanner;

/**
 * @author: mright
 * @date: Created in 2020/4/19 10:07 AM
 * @desc:
 */
public class LRUCache<T> {

    private static final int CAPACITY = 10;

    private int length;

    private Node<T> head;

    public LRUCache() {
        this.length = 0;
        this.head = new Node<>();
    }

    private void printAll() {
        Node node = head.getNext();
        while (node != null) {
            System.out.println(node.getData() + ",");
            node = node.getNext();
        }

        System.out.println();
    }

    private Node<T> findPreNode(T data) {
        Node node = head;
        while (node.getNext() != null) {
            if (node.getNext().getData().equals(data)) {
                return node;
            }

            node = node.getNext();
        }

        return null;
    }

    private void add(T data) {
        Node<T> preNode = findPreNode(data);

    }

    public static void main(String[] args) {
        LRUCache<Integer> lruCache = new LRUCache<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int data = scanner.nextInt();
            lruCache.add(data);
            lruCache.printAll();
        }
    }

    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public Node() {
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
