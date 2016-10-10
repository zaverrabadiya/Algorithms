package com.zavrab.dpproblems;

public class Solution {

    public static void main(String[] args) {
        // e.g
        // {-7, 10, 9, 2, 3, 8, 8, 1} => 4

        //int[] input = {-7, 10, 9, 2, 3, 8, 8, 1};
        int[] input = {1, 10, 9, 2, 3, 4, 5};

        int length = lisWithCacheIteratively(input);
        //int length = lisWithCache(input);
        //int length = findLongestIncreasingSubsequence(input);

        System.out.print("Longest increasing subsequence length: " + length);
    }

    // Iteratively with Memoization ====================================================
    public static int lisWithCacheIteratively(int[] intArr) {
        int[] cache = new int[intArr.length];
        int max;

        for (int i = intArr.length -1; i >=0; i--) {
            max = 0;

            for (int j = i + 1; j < intArr.length; j++) {
                // Check if a[i] < a[j] and a[j] > max: meaning get the max when traversing from i to j, so cache[i] can carry the max after it
                if (intArr[i] < intArr[j] && cache[j] > max) {
                    max = cache[j];
                }
            }

            cache[i] = max + 1;
        }

        max = 0;
        for (int m : cache) {
            max = Math.max(m, max);
        }
        return max;
    }

    // Recursive with Memoization ========================================================
    public static int lisWithCache(int[] intArr) {
        int[] cache = new int[intArr.length];

        return listWithCache(intArr, 0, cache);
    }

    private static int listWithCache(int[] intArr, int start, int[] cache) {
        if (cache[start] != 0) {
            return cache[start];
        }

        if (start == intArr.length - 1) {
            return 1;
        }

        int max = 0, ans;
        for (int j = start+1; j < intArr.length; j++) {
            if (intArr[start] < intArr[j]) {
                ans = listWithCache(intArr, j, cache);
                max = Math.max(ans, max);
            }

            cache[start] = max;
        }

        return max + 1;
    }

    // Recursive ===================================================================
    public static int findLongestIncreasingSubsequence(int[] intArr) {
        return lis(intArr, 0);
    }

    private static int lis(int[] intArr, int start) {
        if (start == intArr.length - 1) {
            return 1;
        }

        int max = 0, ans;
        for (int j = start+1; j < intArr.length; j++) {
            if (intArr[start] < intArr[j]) {
                ans = lis(intArr, j);
                max = Math.max(ans, max);
            }
        }

        return max + 1;
    }
}
