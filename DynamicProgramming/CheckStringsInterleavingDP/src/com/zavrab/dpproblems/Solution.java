package com.zavrab.dpproblems;

public class Solution {

    public static void main(String[] args) {
        // e.g.
        // I:"adab", A:"ab", B:"ad" => True
        // I:"xxxxyx", A: "y", B:"xxxxx" => True
        // I:"112233", A:"123", B"123" => True
        // I:"112233", A:"132", B"123" => False
        // I:"123", A:"", B"123" => True
        // I:"112233", A:"321", B"321" => False

        String I = "xxxxyx", A = "y", B = "xxxxx";
        System.out.print("Is interleaving: " + isInterleaving(I, A, B));
    }

    public static boolean isInterleaving(String I, String A, String B) {
        if (A.length() + B.length() != I.length()) {
            return false;
        }

        int n = A.length(), m = B.length();
        boolean[][] cache = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {

                int x = i + j - 1; // Index in I string

                if (i == 0 && j == 0) {
                    cache[i][j] = true;
                } else if (i == 0 && B.charAt(j - 1) == I.charAt(x)) {  //Assume string A is empty
                    cache[i][j] = cache[i][j - 1];
                } else if (j == 0 && A.charAt(i - 1) == I.charAt(x)) {  //Assume string B is empty
                    cache[i][j] = cache[i - 1][j];
                } else if (i > 0 && j > 0) {
                    if ((A.charAt(i - 1) == I.charAt(x)) && (B.charAt(j - 1) != I.charAt(x))) {         // String A matches but not B, so carry forward previous result of A string;
                                                                                                        // that assures all the previous characters used and also maintains result in order
                        cache[i][j] = cache[i - 1][j];
                    } else if ((B.charAt(j - 1) == I.charAt(x)) && (A.charAt(i - 1) != I.charAt(x))) {  // String B matches but not A, so carry forward previous result of B string;
                                                                                                        // that assures all the previous characters used
                        cache[i][j] = cache[i][j - 1];
                    } else if ((A.charAt(i - 1) == I.charAt(x)) && (B.charAt(j - 1) == I.charAt(x))) {  // String A and B matches; carry forward only matching result
                        cache[i][j] = cache[i - 1][j] || cache[i][j - 1];
                    }
                }
            }
        }
        return cache[n][m];
    }
}
