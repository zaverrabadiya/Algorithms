package com.zavrab.dpproblems;

// http://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
public class MaxSubMatrix {

    public static void main(String[] args) {

        int[][] mtx = {
                {0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
        };

        maxSubMatrix(mtx);
    }

    public static int maxSubMatrix(int[][] mtx) {
        int r = mtx.length;
        int c = mtx[0].length;
        int[][] s = new int[r][c];

        for (int i = 0; i < r; i++) {
            s[i][0] = mtx[i][0];
        }

        for (int j = 1; j < c; j++) {
            s[0][j] = mtx[0][j];
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (mtx[i][j] == 1) {
                    s[i][j] = Math.min(s[i][j - 1], Math.min(s[i - 1][j - 1], s[i - 1][j])) + mtx[i][j];
                }
            }
        }

        int max = 0, maxI = 0, maxJ = 0;

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (s[i][j] > max) {
                    max = s[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        for (int i = maxI; i > (maxI - max); i--) {
            System.out.println();

            for (int j = maxJ; j > (maxJ - max); j--) {
                System.out.print(mtx[i][j] + " ");
            }
        }

        return max;
    }
}
