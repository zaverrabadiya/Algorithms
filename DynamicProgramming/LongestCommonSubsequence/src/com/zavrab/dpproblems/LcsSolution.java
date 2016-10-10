package com.zavrab.dpproblems;

import java.util.HashSet;

public class LcsSolution {

    public static void main(String[] args) {
        // e.g.
        // "ABCDGH", "AEDFHR" => "ADH"
        // "AGGTAB", "GXTXAYB" => "GTAB"

        String x = "AGGTAB", y = "GXTXAYB";

        System.out.print("LCS: " + getLcs(x, y));
        //System.out.print("LCS length: " + getLcsLengthIteratively(x, y));
        //System.out.print("LCS length:" + getLcsLengthRecursively(x, y));
        //System.out.print("LCS :" + getLcsNaive(x, y));
    }

    //Find LCS ITERATIVELY with CACHE: O(nm)
    public static String getLcs(String strX, String strY) {
        int n = strX.length(), m = strY.length();
        int[][] cache = buildLcsMemoization(strX, strY, n, m);
        String result = "";
        int i = n, j = m;

        while (i > 0 && j > 0) {
            if (strX.charAt(i-1) == strY.charAt(j-1)) {
                result = strX.charAt(i-1) + result;
                i--;
                j--;
            } else if (cache[i-1][j] > cache[i][j-1]) {
                i--;
            } else {
                j--;
            }
        }
        return result;
    }

    // Find LCS LENGTH Iteratively with cache: T(O) = O(nm)
    public static int getLcsLengthIteratively(String strX, String strY) {
        int n = strX.length(), m = strY.length();
        int[][] cache = buildLcsMemoization(strX, strY, n, m);

        return cache[n][m];
    }

    private static int[][] buildLcsMemoization(String strX, String strY, int n, int m) {
        int[][] cache = new int[n+1][m+1]; // Increasing length to + 1, so row 0 and col 0 can be left as it is

        for (int i = 1; i <= n; i++) { // Starting from 1, so i -1 and j -1 comparison won't go out of bound
            for (int j = 1; j <= m; j++) {

                if (strX.charAt(i-1) == strY.charAt(j-1)) {
                    cache[i][j] = cache[i-1][j-1] + 1;
                }
                else {
                    cache[i][j] = Math.max(cache[i-1][j], cache[i][j-1]);
                }
            }
        }
        return cache;
    }

    // Find LCS LENGTH Recursively: T(O) = 2^n
    public static int getLcsLengthRecursively(String strX, String strY) {
        return getLcsLengthRecursivelyInternal(strX, strY);
    }

    private static int getLcsLengthRecursivelyInternal(String strX, String strY) {
        if (strX.length() == 0 || strY.length() == 0) {
            return 0;
        }

        int n = strX.length(), m = strY.length();

        if (strX.charAt(n - 1) == strY.charAt(m - 1)) {
            return 1 + getLcsLengthRecursivelyInternal(strX.substring(0, n - 1), strY.substring(0, m - 1));
        }
        else {
            int maxX = getLcsLengthRecursivelyInternal(strX.substring(0, n - 1), strY);
            int maxY = getLcsLengthRecursivelyInternal(strX, strY.substring(0, m - 1));

            return Math.max(maxX, maxY);
        }
    }

    // Find Longest Common Subsequence : NAIVE but 2^N
    public static String getLcsNaive(String strX, String strY) {
        HashSet<String> setX = new HashSet<String>();
        HashSet<String> setY = new HashSet<String>();
        findSubsequence(strX, 0, setX, "");
        findSubsequence(strY, 0, setY, "");

        String lcs = "";

        for (String s : setX) {
            if (setY.contains(s) && s.length() > lcs.length()) {
                lcs = s;
            }
        }

        return lcs;
    }

    private static void findSubsequence(String strInput, int start, HashSet<String> set, String partialSet) {
        if (start == strInput.length()) {
            set.add(partialSet);
            return;
        }

        findSubsequence(strInput, start + 1, set, partialSet);
        partialSet += strInput.charAt(start);
        findSubsequence(strInput, start + 1, set, partialSet);
    }
}
