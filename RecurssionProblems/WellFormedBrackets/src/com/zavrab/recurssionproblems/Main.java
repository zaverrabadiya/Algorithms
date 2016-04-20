package com.zavrab.recurssionproblems;

public class Main {

    public static void main(String[] args) {
        brackets(3);
    }

    public static void  brackets(int n) {
        brackets(" ", 0, 0, n);
    }

    private static void brackets(String output, int l, int r, int n) {
        if (l == n && r == n) {
            System.out.print(output);
            return;
        }

        if (l < n) {
            brackets(output + "(", l + 1, r, n);
        }
        if (r < l ) {
            brackets(output + ")", l, r + 1, n);
        }
    }
}
