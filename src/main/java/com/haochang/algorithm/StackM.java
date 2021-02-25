package com.haochang.algorithm;

import java.util.Stack;

/**
 * @description: 描述：栈
 * @author: youzhi.gao
 * @date: 2021-02-24 16:36
 */
public class StackM {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public StackM(){
        stack =  new Stack();
        minStack =  new Stack();
    }


    public void push(Integer val){
       stack.push(val);
       if(minStack.isEmpty() || minStack.peek() >= val){
           minStack.push(val);
       }
    }

    public void pop(){
        if(stack.pop().equals(minStack.peek())){
            minStack.pop();
        }
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }
}
