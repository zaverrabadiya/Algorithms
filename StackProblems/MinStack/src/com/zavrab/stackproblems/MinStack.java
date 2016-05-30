package com.zavrab.stackproblems;

import java.util.Stack;

public class MinStack {

    public static void main(String[] args) {
	    push(1);
        push(2);
        push(3);
        push(4);
        push(5);

        System.out.println("Min: " + getMin());

        push(0);
        System.out.println("Min: " + getMin());

        pop();
        System.out.println("Min: " + getMin());
    }

    private static Stack<Integer> stack = new Stack<Integer>();
    private static Stack<Integer> minStack = new Stack<Integer>();

    public static void push(int val) {
        stack.push(val);

        if (minStack.size() > 0) {
            if (val < minStack.peek()) {
                minStack.push(val);
            }
        } else {
            minStack.push(val);
        }
    }

    public static int pop() {
        int val = stack.pop();

        if (minStack.size() > 0 && minStack.peek() == val) {
            minStack.pop();
        }
        return val;
    }

    public static int getMin() {
        return minStack.size() > 0 ? minStack.peek() : Integer.MIN_VALUE;
    }
}
