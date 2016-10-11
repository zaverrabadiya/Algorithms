package com.zavrab.dpproblems;

/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Output= 3
 *
 * http://www.programcreek.com/2013/01/leetcode-distinct-subsequences-total-java/
 *
 * */
public class TotalDistinctSubSequences {

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";

        System.out.println("\nTotal sub-sequences: " + findTotalDistinctSunsequences(s, t));
    }

    public static int findTotalDistinctSunsequences(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }

        int[][] cache = new int[s.length()+1][t.length()+1];

        // Set first column to 1
        for (int i = 0; i < s.length(); i++) {
            cache[i][0] = 1;
        }

        // Actual algorithm to count the total sub-sequences of T
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {

                if (s.charAt(i-1) == t.charAt(j-1)) {
                    // Total of previous char in S and same char of T + previous char in S and previous char in T
                    cache[i][j] = cache[i-1][j] + cache[i-1][j-1];
                }
                else {
                    // Carry forward the result of previous char of S and same char of T
                    cache[i][j] = cache[i-1][j];
                }
            }
        }

        // PRINT FOR DEBUG PURPOSE ONLY
        printDebugTable(cache);

        return cache[s.length()][t.length()];
    }

    private static void printDebugTable(int[][] cache) {
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[0].length; j++) {

                System.out.print(cache[i][j] + "\t");
            }

            System.out.println();
        }
    }
}
