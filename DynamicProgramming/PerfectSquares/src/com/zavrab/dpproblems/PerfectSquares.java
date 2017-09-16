package com.zavrab.dpproblems;

import java.util.Arrays;

/***
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 *
 * This is a dp problem. The key is to find the relation which is dp[i] = min(dp[i], dp[i-square]+1). For example, dp[5]=dp[4]+1=1+1=2.
 *
 * http://www.programcreek.com/2014/05/leetcode-perfect-squares-java/
 *
 */

public class PerfectSquares {

    public static void main(String[] args) {
        int n = 12;
        System.out.format("Number of squares for: %d is: %d",n, findNumberOfSquares(n));

        n = 13;
        System.out.format("\nNumber of squares for: %d is: %d",n, findNumberOfSquares(n));
    }

    public static int findNumberOfSquares(int n) {
        int max;
        int[] cache = new int[n+1];
        Arrays.fill(cache, Integer.MAX_VALUE);

        for (int i = 1; i <= n; i++) {
            max = (int)Math.sqrt(i); //Get sqrt of current number

            for (int j = 1; j <= max; j++) {
                int square = j * j;

                if (i == square) {
                    cache[i] = 1;
                }
                else if (i > square) {
                    // Get the minimum number of squares of current number-square 1...max
                    // cache[5] = cache[5]+1 = 1+1=2 and cache[number - square]+1 = 1+1=2
                    cache[i] = Math.min(cache[i], cache[i - square] + 1);
                }
            }
        }

        return cache[n];
    }
}
