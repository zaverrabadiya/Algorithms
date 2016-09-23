package com.zavrab.adhoc;

public class Solution {

    /**
     * https://www.hackerrank.com/challenges/shortest-path/copy-from/28476757
     *
     * Sample Input:
     *
     *    0 0 0 0 0
     *    1 9 9 9 1
     *    0 0 0 0 0
     *
     *    0 0 2 4
     *    0 3 2 3
     *    1 1 1 3
     *
     *   Sample Output:
     *    1
     *    1
     *    18
     *
     * */
    public static void main(String[] args) {
        int[][] table = new int[][]
                {
                    { 0, 0, 0, 0, 0},
                    { 1, 9, 9, 9, 1},
                    { 0, 0, 0, 0, 0}
                };

        int[][] query = new int[][]
                {
                    { 0, 0, 2, 4},
                    { 0, 3, 2, 3},
                    { 1, 1, 1, 3},
                    { 2, 4, 1, 1}
                };

        findMinWeight(table, query);
    }

    public static void findMinWeight(int[][] table, int[][] query) {

        for (int i = 0; i < query.length; i++) {
            boolean[][] tracker = new boolean[table.length][table[0].length];
            int[][] cache = initCache(table.length, table[0].length);

            int minWeight = findMinWeightRec(table, query[i][0], query[i][1], query[i][2], query[i][3], tracker, cache);

            System.out.println(minWeight);
        }
    }

    private static int findMinWeightRec(int[][] table, int i, int j, int x, int y, boolean[][] tracker, int[][] cache) {
        if (i == x && j == y) {
            return table[i][j];
        }

        if ((i < 0 || i == table.length) || (j < 0 || j == table[0].length)) {
            return Integer.MAX_VALUE;
        }

        if (!tracker[i][j]) {
            tracker[i][j] = true;

            int rightWeight = findMinWeightRec(table, i, j + 1, x, y, tracker, cache);
            int downWeight = findMinWeightRec(table, i + 1, j, x, y, tracker, cache);
            int leftWeight = findMinWeightRec(table, i, j - 1, x, y, tracker, cache);
            int topWeight = findMinWeightRec(table, i - 1, j, x, y, tracker, cache);

            int minRightDown = Math.min(rightWeight, downWeight);
            int minTopLeft = Math.min(leftWeight, topWeight);

            int minWeight = Math.min(cache[i][j], Math.min(minRightDown, minTopLeft));

            if (minWeight != Integer.MAX_VALUE) {
                cache[i][j] = minWeight + table[i][j];
            }

            // Done on this route, so turn it back to false for other possible route to come back
            tracker[i][j] = false;
        }

        return cache[i][j];
    }

    private static int[][] initCache(int n, int m) {
        int[][] cache = new int[n][m];

        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[i].length; j++) {
                cache[i][j] = Integer.MAX_VALUE;
            }
        }

        return cache;
    }
}
