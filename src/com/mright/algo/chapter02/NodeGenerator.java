package com.mright.algo.chapter02;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/5/7 10:42
 */
public class NodeGenerator {

    /**
     * 获取一颗  1--15  的二叉树
     *
     * @return 二叉树
     */
    public Node initBinaryTree() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        Node node13 = new Node(13);
        Node node14 = new Node(14);
        Node node15 = new Node(15);

        node1.setChild(node2, node3);
        node2.setChild(node4, node5);
        node3.setChild(node6, node7);
        node4.setChild(node8, node9);
        node5.setChild(node10, node11);
        node6.setChild(node12, node13);
        node7.setChild(node14, node15);

        return node1;
    }

    public Node initBinarySearchTree() {
        Node node33 = new Node(33);
        Node node17 = new Node(17);
        Node node50 = new Node(50);
        Node node13 = new Node(13);
        Node node18 = new Node(18);
        Node node34 = new Node(34);
        Node node58 = new Node(58);
        Node node16 = new Node(16);
        Node node25 = new Node(25);
        Node node51 = new Node(51);
        Node node66 = new Node(66);
        Node node19 = new Node(19);
        Node node27 = new Node(27);

        node33.setChild(node17, node50);
        node17.setChild(node13, node18);
        node50.setChild(node34, node58);
        node13.setChild(null, node16);
        node18.setChild(null, node25);
        node58.setChild(node51, node66);
        node25.setChild(node19, node27);

        return node33;
    }
}
