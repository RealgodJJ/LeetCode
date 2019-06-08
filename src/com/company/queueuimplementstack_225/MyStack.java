package com.company.queueuimplementstack_225;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> queue_1;
    private Queue<Integer> queue_2;

    /**
     * Initialize your data structure here.
     */
    private MyStack() {
        queue_1 = new LinkedList<>();
        queue_2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    private void push(int x) {
//        queue_1.offer(x);
        queue_1.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    private int pop() {
        while (queue_1.size() != 1) {
//            queue_2.offer(queue_1.poll());
            queue_2.add(queue_1.remove());
        }
//        int temp = queue_1.poll();
        int temp = queue_1.remove();
        while (queue_2.size() != 0) {
//            queue_1.offer(queue_2.poll());
            queue_1.add(queue_2.remove());
        }
        return temp;
    }

    /**
     * Get the top element.
     */
    private int top() {
        while (queue_1.size() != 1) {
//            queue_2.offer(queue_1.poll());
            queue_2.add(queue_1.remove());
        }
        return queue_1.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    private boolean empty() {
        return queue_1.size() == 0;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}
