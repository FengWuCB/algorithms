package com.sxw.algorithms.tree;

/**
 * @author 苏雄伟 [suxiongwei@kaoshixing.com]
 * @description 二叉树相关编程题
 * @date 2019/12/26 4:09 下午
 */
public class TreeQuestions {
    /**
     * 二叉树先序遍历-递归实现
     * @param head
     */
    public static void preOrderRecur(Node head){
        if (null == head){
            return;
        }
        System.out.print(head.getValue() + " ");
        preOrderRecur(head.getLeft());
        preOrderRecur(head.getRight());
    }

    /**
     * 二叉树中序遍历-递归实现
     * @param head
     */
    public static void inOrderRecur(Node head){
        if (null == head){
            return;
        }
        inOrderRecur(head.getLeft());
        System.out.print(head.getValue() + " ");
        inOrderRecur(head.getRight());
    }

    /**
     * 二叉树后序遍历-递归实现
     * @param head
     */
    public static void posOrderRecur(Node head){
        if (null == head){
            return;
        }
        posOrderRecur(head.getLeft());
        posOrderRecur(head.getRight());
        System.out.print(head.getValue() + " ");
    }

    /**
     * 组装二叉树数据
     * @return
     */
    public static Node getNode(){
        Node node7 = Node.builder().value(7).build();
        Node node6 = Node.builder().value(6).build();
        Node node5 = Node.builder().value(5).build();
        Node node4 = Node.builder().value(4).build();
        Node node3 = Node.builder().value(3).left(node6).right(node7).build();
        Node node2 = Node.builder().value(2).left(node4).right(node5).build();
        Node node1 = Node.builder().value(1).left(node2).right(node3).build();
        return node1;
    }

    public static void main(String[] args) {
        // 后序遍历
        posOrderRecur(getNode());
    }
}
