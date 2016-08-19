package com.zavrab.adhoc;

public class Main {

/**
 * Write a function that takes in a float[][] array, representing an image after edge detection has been applied,
 * and returns a single float between 0 and 1, which is the value of the best horizon in the picture.
 *
 * [
 *   [ 1, 2, 3]
 *   [ 4, 5, 6]
 *   [ 7, 8, 9]
 *  ]
 *
 * [
 *  [1, 2, 3]
 *  [4, 8, 9]
 *  [7, 5, 6]
 * ]
 *
 */

//TODO: Pending implementation
    public static void main(String[] args) {
        // write your code here
    }

    public static int bestHorizon(int[][] mtrx) {
        int rows = mtrx.length;
        int cols = mtrx[0].length;

        int[][] cache = new int[rows][cols];
        initCache(cache);

        for (int i = 0; i < rows; i++) {
            findMinRec(mtrx, i, 0, rows, cols, cache);
        }

        return 0;
    }

    private static int findMinRec(int[][] mtrx, int i, int j, int rows, int cols, int[][] cache) {

        if (i >= rows || j >= cols) {
            return Integer.MIN_VALUE;
        }

        if (cache[i][j] != -1) {
            return cache[i][j];
        }

        int minTop = Integer.MIN_VALUE, minRight = Integer.MIN_VALUE, minBottom = Integer.MIN_VALUE;

        if (j < cols) {
            minRight = findMinRec(mtrx, i, j + 1, rows, cols, cache);
            minRight = Math.min(mtrx[i][j], minRight);
        }

        if (i < rows - 1 && j < cols) {
            minBottom = findMinRec(mtrx, i + 1, j + 1, rows, cols, cache);
            minBottom = Math.min(mtrx[i][j], minBottom);
        }

        if (i > 0 && j < cols) {
            minTop = findMinRec(mtrx, i - 1, j + 1, rows, cols, cache);
            minTop = Math.min(mtrx[i][j], minTop);
        }

        cache[i][j] = Math.max(minTop, Math.max(minRight, minBottom));

        return cache[i][j];
    }

    private static void initCache(int[][] cache) {
        int rows = cache.length;
        int cols = cache[0].length;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                cache[i][j] = -1;
            }
        }
    }
}