package com.zavrab.arrayproblems;

/**
 * Rotate 2D array
 *
 * input:
 * 1 2 3
 * 4 5 6
 * 7 8 9
 *
 * output:
 * 7 4 1
 * 8 5 2
 * 9 6 3
 *
 * */
public class Rotate2DArray {

    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        rotate2DArray(arr);
        print2DArray(arr);
    }

    public static void rotate2DArray(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int arrLen = arr.length - 1;

        // I takes layer by layer
        for (int i = 0; i < arr.length/2; i++) {
            for (int j = i; j < (arrLen - i); j++) {

                int temp1 = arr[arrLen - j][i];
                int temp2 = arr[arrLen - i][arrLen - j];
                int temp3 = arr[j][arrLen - i];
                int temp4 = arr[i][j];

                arr[i][j] = temp1;
                arr[j][arrLen - i] = temp4;
                arr[arrLen - i][arrLen - j] = temp3;
                arr[arrLen - j][i] = temp2;
            }
        }
    }

    private static void print2DArray(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }

            System.out.println();
        }
    }
}
