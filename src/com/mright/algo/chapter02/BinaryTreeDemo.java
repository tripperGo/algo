package com.mright.algo.chapter02;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/5/7 10:18
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        Node tree = new NodeGenerator().initBinaryTree();

        postOrder(tree);
    }

    /**
     * 前序遍历
     *
     * @param tree 树
     */
    public static void preOrder(Node tree) {
        if (tree != null) {
            System.out.print(tree.getData() + "\t");
            preOrder(tree.getLeft());
            preOrder(tree.getRight());
        }
    }

    /**
     * 中序遍历
     *
     * @param tree 树
     */
    public static void inOrder(Node tree) {
        if (tree != null) {
            inOrder(tree.getLeft());
            System.out.print(tree.getData() + "\t");
            inOrder(tree.getRight());
        }
    }

    /**
     * 后序遍历
     *
     * @param tree 树
     */
    public static void postOrder(Node tree) {
        if (tree != null) {
            postOrder(tree.getLeft());
            postOrder(tree.getRight());
            System.out.print(tree.getData() + "\t");
        }
    }

}