package com.zavrab.dpproblems;

import java.util.HashSet;

public class LcsSolution {

    public static void main(String[] args) {
        // e.g.
        // "ABCDGH", "AEDFHR" => "ADH"
        // "AGGTAB", "GXTXAYB" => "GTAB"

        String x = "AGGTAB", y = "GXTXAYB";

        System.out.print("LCS: " + findLcs(x, y));
        //System.out.print("LCS length: " + findLcsLengthIteratively(x, y));
        //System.out.print("LCS length:" + findLcsLengthRecursively(x, y));
        //System.out.print("LCS :" + findLcsNaive(x, y));
    }

    //Finc LCS ITERATIVELY with CACHE:
    public static String findLcs(String strX, String strY) {
        int n = strX.length(), m = strY.length();
        int[][] cache = buildLcsMemoization(strX, strY, n, m);
        String result = "";
        int i = n-1, j = m-1;

        while (i >= 0 && j >= 0) {
            if (strX.charAt(i) == strY.charAt(j)) {
                result = strX.charAt(i) + result;
                i--;
                j--;
            } else if (cache[i - 1][j] > cache[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return result;
    }

    // Find LCS LENGTH Iteratively with cache: T(O) = O(nm)
    public static int findLcsLengthIteratively(String strX, String strY) {
        int n = strX.length(), m = strY.length();
        int[][] cache = buildLcsMemoization(strX, strY, n, m);
        return cache[n-1][m-1];
    }

    private static int[][] buildLcsMemoization(String strX, String strY, int n, int m) {
        int[][] cache = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    if (strX.charAt(i) == strY.charAt(j)) {
                        cache[i][j] = 1;
                    } else if (i > 0){
                        cache[i][j] = cache[i - 1][j];
                    } else {
                        cache[i][j] = 0;
                    }
                } else if (strX.charAt(i) == strY.charAt(j)) {
                    cache[i][j] = cache[i-1][j-1] + 1;
                } else {
                    cache[i][j] = Math.max(cache[i-1][j], cache[i][j-1]);
                }
            }
        }
        return cache;
    }

    // Find LCS LENGTH Recursively: T(O) = 2^n
    public static int findLcsLengthRecursively(String strX, String strY) {
        return findLcsLengthRecursivelyInternal(strX, strY);
    }

    private static int findLcsLengthRecursivelyInternal(String strX, String strY) {
        if (strX.length() == 0 || strY.length() == 0) {
            return 0;
        }

        int n = strX.length(), m = strY.length();

        if (strX.charAt(n - 1) == strY.charAt(m - 1)) {
            return 1 + findLcsLengthRecursivelyInternal(strX.substring(0, n - 1), strY.substring(0, m - 1));
        } else {
            int maxX = findLcsLengthRecursivelyInternal(strX.substring(0, n - 1), strY);
            int maxY = findLcsLengthRecursivelyInternal(strX, strY.substring(0, m - 1));
            return Math.max(maxX, maxY);
        }
    }

    // Find Longest Common Subsequence : NAIVE but 2^N
    public static String findLcsNaive(String strX, String strY) {
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
