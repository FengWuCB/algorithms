package com.sxw.algorithms.stack;

import java.util.Stack;

/**
 * @author 苏雄伟 [suxiongwei@kaoshixing.com]
 * @description 编写一个类，用两个栈实现队列，支持队列的基本操作（add、poll、peek）
 * @date 2019-10-25 15:34
 */
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

    public static void main(String[] args) {
        TwoStacksQueue queue = new TwoStacksQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        queue.add(1);
        System.out.println(queue.peek());
    }
}
