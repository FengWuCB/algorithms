# 算法与数据结构题目最优解

> 书籍《程序员代码面试指南：IT名企算法与数据结构题目最优解》学习记录
[TOC]
## 栈和队列

### 1、实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作

   ```java
   public class MyStack {
       private Stack<Integer> stackData;
       private Stack<Integer> stackMin;
   
       public MyStack(){
           stackData = new Stack<>();
           stackMin = new Stack<>();
       }
   
       public void push(int newNum){
           if (stackMin.isEmpty()){
               stackMin.push(newNum);
           }else if(newNum < getMin()){
               stackMin.push(newNum);
           }else{
               stackMin.push(stackMin.peek());
           }
   
           stackData.push(newNum);
       }
   
       public int pop(){
           if (stackMin.isEmpty()){
               throw new RuntimeException("your stack is empty");
           }
           stackMin.pop();
           return stackData.pop();
       }
   
       public int getMin(){
           if (stackMin.isEmpty()){
               throw new RuntimeException("your stack is empty");
           }
   
           return stackMin.peek();
       }
   }
   ```

   

### 2、一个栈依次压入1、2、3、4、5，那么从栈顶到栈底分别为5、4、3、2、1。将这个栈转置后，从栈顶到栈底为 1、2、3、4、5，也就是实现栈中元素的逆序，但是只能用递归函数来实现，不能用其他数据结构

  ```java
  public class ReverseStack {
      public static int getAndRemoveLastElement(Stack<Integer> stack){
          int result = stack.pop();
          if (stack.isEmpty()){
              return result;
          } else {
              int last = getAndRemoveLastElement(stack);
              stack.push(result);
              return last;
          }
      }
  
      public static void reverse(Stack<Integer> stack){
          if (stack.isEmpty()){
              return;
          }
          int i = getAndRemoveLastElement(stack);
          reverse(stack);
          stack.add(i);
      }
  }
  ```

  

### 3、编写一个类，用两个栈实现队列，支持队列的基本操作（add、poll、peek）

   ```java
   public class TwoStacksQueue {
       private Stack<Integer> stackPush;
       private Stack<Integer> stackPop;
   
       public TwoStacksQueue(){
           stackPush = new Stack<>();
           stackPop = new Stack<>();
       }
   
       /**
        * push 栈向pop栈倒入数据
        */
       public void pushToPop(){
           if (stackPop.isEmpty()){
               while (!stackPush.isEmpty()){
                   stackPop.push(stackPush.pop());
               }
           }
       }
   
       public void add(int pushInt){
           stackPush.push(pushInt);
           pushToPop();
       }
   
       public int peek(){
           if (stackPush.isEmpty() && stackPop.isEmpty()){
               throw new RuntimeException("error");
           }
   
           pushToPop();
           return stackPop.peek();
       }
   
       public int poll(){
           if (stackPush.isEmpty() && stackPop.isEmpty()){
               throw new RuntimeException("error");
           }
   
           pushToPop();
           return stackPop.pop();
       }
   }
   ```

## 链表

### 1、给定两个有序链表的头指针head1和head2，打印两个链表的公共部分

   ```java
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
   ```

### 2、反转单链表

   ```java
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
   ```

   

### 3、反转双链表

   ```java
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
   ```

   

### 4、单链表中删除指定值的节点

   ```java
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
   ```

   

### 5、删除无序单链表中重复出现的节点

   ```java
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
   ```

   

## 二叉树

### 1、二叉树遍历

   ```java
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
   ```

## 字符串问题

### 1、判断两个字符串是否互为变形词

   ```java
   public static boolean isDeformation(String str1, String str2){
           if (StringUtils.isEmpty(str1) || StringUtils.isEmpty(str2) || str1.length() != str2.length()){
               return false;
           }
           char[] char1 = str1.toCharArray();
           char[] char2 = str2.toCharArray();
           int[] map = new int[256];
           for (int i = 0; i < char1.length; i++){
               map[char1[i]] ++;
           }
           for (int i = 0; i < char2.length; i++){
               int tmp = map[char2[i]]--;
               if (tmp == 0){
                   return false;
               }
           }
           return true;
       }
   ```

   
