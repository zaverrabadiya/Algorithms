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

        System.out.print("Max len: " + maxLenMatchingParantheses("(((())(((()"));
    }

    public static int maxLenMatchingParantheses(String inStr) {
        Stack<Character> paranStack = new Stack<Character>();
        int len = 0, maxSoFar = 0;

        for (int i = 0; i < inStr.length(); i++) {
            if (inStr.charAt(i) == ')' && (!paranStack.isEmpty() && paranStack.pop() == '(')) {
                maxSoFar += 2;
            } else {
                paranStack.push(inStr.charAt(i));
                len = Math.max(len, maxSoFar);
                maxSoFar = 0;
            }
        }

        return len;
    }
}
