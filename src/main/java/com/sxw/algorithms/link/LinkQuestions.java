package com.sxw.algorithms.link;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author 苏雄伟 [suxiongwei@kaoshixing.com]
 * @description 链表编程题
 * @date 2019/12/26 4:40 下午
 */
public class LinkQuestions {
    /**
     * 给定两个有序链表的头指针head1和head2，打印两个链表的公共部分
     * @param head1
     * @param head2
     */
    public static void printCommonPart(Node head1, Node head2){
        System.out.println("common part begin:");
        while (head1 != null && head2 == null){
            if (head1.value > head2.value){
                head1 = head1.next;
            }else if (head1.value < head2.value){
                head2 = head2.next;
            }else {
                System.out.println("commom value:" + head1.value);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }

    /**
     * 反转单链表
     * @param head
     * @return
     */
    public static Node reverseList(Node head){
        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 反转双链表
     * @param head
     * @return
     */
    public static DoubleNode reverseList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 单链表中删除指定值的节点
     * 利用栈来实现
     * 时间复杂度O(N),额外空间复杂度O(N)
     * @param head
     * @param num
     * @return
     */
    public static Node removeValue1(Node head, int num){
        Stack<Node> stack = new Stack<>();
        while (null != head){
            if (head.getValue() != num){
                stack.push(head);
            }
            head = head.getNext();
        }
        while (!stack.isEmpty()){
            stack.peek().next = head;
            head = stack.pop();
        }

        return head;
    }

    /**
     * 单链表中删除指定值的节点
     * 不利用任何容器直接删除
     * 时间复杂度O(N),额外空间复杂度O(1)
     * @param head
     * @param num
     * @return
     */
    public static Node removeValue2(Node head, int num){
        while (head.next != null){
            if (head.value != num){
                break;
            }
            head = head.next;
        }
        Node cur = head;
        Node pre = head;

        while (cur != null){
            if (cur.value == num){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * 删除无序单链表中重复出现的节点
     * 利用hash实现
     * 时间复杂度O(N),额外空间复杂度O(N)
     * @param head
     */
    public static void removePre(Node head){
        if (head == null){
            return;
        }

        Set<Integer> set = new HashSet<>();
        Node pre = head;
        Node cur = head.next;
        set.add(cur.value);
        while (cur.next != null){
            if (set.contains(cur.value)){
                pre.next = cur.next;
            }else {
                set.add(cur.value);
                pre = cur;
            }
        }
    }



    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        // 翻转链表
        printNode(node1);
        System.out.println();
        printNode(reverseList(node1));



    }

    public static void printNode(Node node){
        while (node != null){
            System.out.print(node.value);
            node = node.next;
        }
    }
}
