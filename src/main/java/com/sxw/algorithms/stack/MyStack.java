package com.sxw.algorithms.stack;

import java.util.Stack;

/**
 * @author 苏雄伟 [suxiongwei@kaoshixing.com]
 * @description 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 * @date 2019-10-25 15:05
 */
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

    public static void main(String[] args) {
        MyStack stack_1 = new MyStack();
        stack_1.push(3);
        stack_1.push(4);
        stack_1.push(5);
        stack_1.push(1);
        stack_1.push(2);
        stack_1.push(1);

        stack_1.pop();
        System.out.println(stack_1.getMin());

        stack_1.pop();
        System.out.println(stack_1.getMin());

        stack_1.pop();
        System.out.println(stack_1.getMin());

        stack_1.push(0);
        System.out.println(stack_1.getMin());
    }
}
