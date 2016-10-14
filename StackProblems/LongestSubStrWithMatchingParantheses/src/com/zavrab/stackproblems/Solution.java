package com.zavrab.stackproblems;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
	    // Longest substring with matching parantheses

        // e.g.
        // "(((())(((()" => 4 (())
        // "(((((" => 0
        // "()()()" => 6
        // "" => 0

        System.out.print("Max len: " + maxLenMatchingParantheses("(((())()"));
    }

    public static int maxLenMatchingParantheses(String inStr) {
        Stack<Integer> paranStack = new Stack<Integer>();
        int len = 0;

        paranStack.push(-1);

        for (int i = 0; i < inStr.length(); i++) {
            if (inStr.charAt(i) == '(') {
                paranStack.push(i);
            } else {
                paranStack.pop();

                if (!paranStack.isEmpty()) {
                    len = Math.max(len, i - paranStack.peek());
                } else {
                    paranStack.push(i);
                }
            }
        }

        return len;
    }
}
