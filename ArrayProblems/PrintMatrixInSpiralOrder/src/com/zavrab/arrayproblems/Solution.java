package com.zavrab.arrayproblems;

public class Solution {

    public static void main(String[] args) {
        int n = 4, m = 4;
        int[][] matrix = new int[n][m];
        int val = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = val++;
            }
        }

        printMatrixInSpiral(matrix, n, m);
    }

    public static void printMatrixInSpiral(int[][] matrix, int n, int m) {
        int border = 0, i, j;

        while (border < (n - border) || border < (m - border)) {
            i = border;
            j = border;

            for (;j < ((m - 1) - border); j++) {
                System.out.print(matrix[i][j] + " ");
            }

            for (; i < ((n - 1) - border); i++) {
                System.out.print(matrix[i][j] + " ");
            }

            for (; j > border; j--) {
                System.out.print(matrix[i][j] + " ");
            }

            for (; i > border; i--) {
                System.out.print(matrix[i][j] + " ");
            }

            border++;
        }
    }
}
