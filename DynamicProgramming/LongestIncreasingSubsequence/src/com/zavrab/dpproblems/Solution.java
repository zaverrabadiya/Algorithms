package com.zavrab.dpproblems;

public class Solution {

    public static void main(String[] args) {
        // e.g
        // {-7, 10, 9, 2, 3, 8, 8, 1} => 4

        int[] input = {-7, 10, 9, 2, 3, 8, 8, 1};
        //int[] input = {1, 10, 9, 2, 3, 4, 5};
        int length = lisWithCache(input);
        System.out.print("Longest increasing subsequence length: " + length);
    }

    public static int findLongestIncreasingSubsequence(int[] intArr) {
        int max = 1;
        for (int i = 0; i < intArr.length; i++) {
            int ans = lis(intArr, i);
            max = Math.max(ans, max);
        }
        return max;
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

    public static int lisWithCache(int[] intArr) {
        int max = 1;
        int[] cache = new int[intArr.length];
        for (int i = 0; i < intArr.length; i++) {
            int ans = listWithCache(intArr, i, cache);
            max = Math.max(ans, max);
        }
        return max;
    }

    private static int listWithCache(int[] intArr, int start, int[] cache) {
        if (cache[start] != 0) {
            return cache[start];
        }

        if (start == intArr.length - 1) {
            return 1;
        }

        int max = 0, ans = 0;
        for (int j = start+1; j < intArr.length; j++) {
            if (intArr[start] < intArr[j]) {
                ans = listWithCache(intArr, j, cache);
                max = Math.max(ans, max);
            }
            cache[start] = max;
        }
        return max + 1;
    }
}
