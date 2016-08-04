package com.zavrab.dpproblems;

public class Fibonacci {

    public static void main(String[] args) {
        int n = 6;
        System.out.format("Fibonacci of %d is %d", n, fibDp(n));
    }

    // DP Solution
    private static int fibDp(int n) {
        int one = 1;
        int two = 0;
        int total = 0;

        for (int i = 2; i <= n; i++) {
            total = one + two;
            two = one;
            one  = total;
        }

        return total;
    }

    // RECURSION Solution
    private static int fibRec(int n) {
        if (n <= 1) {
            return n;
        }

        return fibRec(n - 1) + fibRec( n - 2);
    }


}
