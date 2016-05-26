package com.zavrab.stackproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SuperStack {

    // You need to take a peek at the value on top of the stack and print it to output after every operation
    // If stack is empty then print "EMPTY".

    // Allowable operations
    // Push
    // Pop
    // Inc x d : Add the value d to each of the bottom x elements on the stack

    /*
    * The state of the whole stack is represented in [] bottom to top
    * push(4)   [4]
    * pop()     [] - sine stack is empty print "EMPTY" after this operation
    * push(3)   [3]
    * push(5)   [3, 5]
    * push(2)   [3, 5, 1]
    * inc(3, 1) [4, 6, 3]
    * pop()     [4, 6]
    * */

    private static List<Integer> list = new ArrayList<Integer>(); // List backed stack

    public static void main(String[] args) {
        push(4);
        pop();
        push(3);
        push(5);
        push(2);
        increment(3, 1);
        pop();
        push(1);
        increment(2, 2);
        push(4);
        pop();
        pop();
    }

    public static void push(int val) {
        list.add(val);
        System.out.println(list.get(list.size() - 1));
    }

    public static void pop() {
        list.remove(list.size() - 1);

        if (list.size() == 0) {
            System.out.println("EMPTY");
        } else {
            System.out.println(list.get(list.size() - 1));
        }
    }

    public static void increment(int x, int d) {
        for (int i = 0; i < x; i++) {
            int curr = list.get(i);
            list.set(i, curr + d);
        }

        System.out.println(list.get(list.size() - 1));
    }
}
