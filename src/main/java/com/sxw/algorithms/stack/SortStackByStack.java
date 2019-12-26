package com.sxw.algorithms.stack;

import java.util.Stack;

/**
 * @author 苏雄伟 [suxiongwei@kaoshixing.com]
 * @description
 * @date 2019-10-25 16:45
 */
public class SortStackByStack {
    public static void sortStackByStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()){
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek() < cur){
                stack.push(help.pop());
            }
            help.push(cur);
        }

        while (!help.isEmpty()){
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(5);
        sortStackByStack(stack);

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
