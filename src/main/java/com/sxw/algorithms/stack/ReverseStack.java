package com.sxw.algorithms.stack;

import java.util.Stack;

/**
 * @author 苏雄伟 [suxiongwei@kaoshixing.com]
 * @description <p>一个栈依次压入1、2、3、4、5，那么从栈顶到栈底分别为5、4、3、2、1。
 *              将这个栈转置后，从栈顶到栈底为 1、2、3、4、5，也就是实现栈中元素的逆序，但是只能用递归函数来实现，不能用其他数据结构
 *              </p>
 * @date 2019-10-25 16:13
 */
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


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);

        reverse(stack);

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
