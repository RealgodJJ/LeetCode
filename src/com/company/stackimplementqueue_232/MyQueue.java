package com.company.stackimplementqueue_232;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stack_1;
    private Stack<Integer> stack_2;

    /**
     * Initialize your data structure here.
     */
    private MyQueue() {
        //利用两个栈重复放置
        stack_1 = new Stack<>();
        stack_2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    private void push(int x) {
        stack_1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    private int pop() {
        if (stack_2.size() == 0) {
            while (stack_1.size() > 0) {
                stack_2.push(stack_1.pop());
            }
        }
        return stack_2.pop();
    }

    /**
     * Get the front element.
     */
    private int peek() {
        if (stack_2.size() == 0) {
            while (stack_1.size() > 0) {
                stack_2.push(stack_1.pop());
            }
        }
        return stack_2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    private boolean empty() {
        return stack_1.size() == 0 && stack_2.size() == 0;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        myQueue.push(5);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }
}
