package com.mright.algo.chapter02;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/5/7 10:47
 */
public class BinarySearchTreeDemo {

    public static void main(String[] args) {
        Node tree = new NodeGenerator().initBinarySearchTree();

        // 中序
        inOrder(tree);

        // 二叉查找
        searchDemo(tree);

        // 插入
        int data = 26;
        System.out.println("================= 插入操作：" + data + " ==================");
        insert(tree, data);
        inOrder(tree);

        int dData = 18;
        System.out.println();
        System.out.println("================= 删除操作：" + dData + " ==================");
        delete(tree, dData);
        inOrder(tree);
    }

    private static void delete(Node tree, int data) {
        Node p = tree;
        Node parent = null;
        while (p != null && p.getData() != data) {
            parent = p;
            if (data > p.getData()) {
                p = p.getRight();
            } else {
                p = p.getLeft();
            }
        }

        // 没有找到
        if (p == null) {
            System.out.println("没有找到，删除失败！！！");
            return;
        }

        // 要删除的有两个节点
        if (p.getLeft() != null && p.getRight() != null) {
            // 查找右子树的最小节点
            Node minP = p.getRight();
            Node minParent = p;
            while (minP != null) {
                minParent = minP;
                minP = minP.getLeft();
            }
            p.setData(minP.getData());
            p = minP;
            parent = minParent;
        }

        Node child; // p的子节点
        if (p.getLeft() != null) {
            child = p.getLeft();
        } else if (p.getRight() != null) {
            child = p.getRight();
        } else {
            child = null;
        }

        if (parent == null) {
            tree = child; // 删除的是根节点
        } else if (parent.getLeft() == p) {
            parent.setLeft(child);
        } else {
            parent.setRight(child);
        }
    }

    private static void insert(Node tree, int data) {
        if (tree == null) {
            return;
        }

        if (data > tree.getData()) {
            if (tree.getRight() == null) {
                tree.setRight(new Node(data));
            } else {
                insert(tree.getRight(), data);
            }
        } else {
            if (tree.getLeft() == null) {
                tree.setLeft(new Node(data));
            } else {
                insert(tree.getLeft(), data);
            }
        }
    }

    private static void searchDemo(Node tree) {
        int data = 13;
        System.out.println();
        System.out.println("================= 查找节点值为：" + data + "的节点 ==================");
        Node searchNode = search(tree, data);
        if (searchNode == null) {
            System.out.println("未找到节点值为" + data);
        } else {
            System.out.println(searchNode.getData() + " ==> " +
                    (searchNode.getLeft() == null ? "左子树为空" : searchNode.getLeft().getData()) + " ==> " +
                    (searchNode.getRight() == null ? "右子树为空" : searchNode.getRight().getData()));
        }
    }

    private static Node search(Node tree, int data) {
        if (tree != null) {
            if (data < tree.getData()) {
                return search(tree.getLeft(), data);
            } else if (data > tree.getData()) {
                return search(tree.getRight(), data);
            } else {
                return tree;
            }
        }
        return null;
    }

    private static void inOrder(Node tree) {
        if (tree != null) {
            inOrder(tree.getLeft());
            System.out.print(tree.getData() + "\t");
            inOrder(tree.getRight());
        }
    }
}
