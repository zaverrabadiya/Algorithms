package com.zavrab.dpproblems;

import java.util.ArrayList;
import java.util.List;

// http://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/

public class BalancedPartitionSolution {

    public static void main(String[] args) {
        //int arr[] = {3, 1, 5, 9, 12};
        //int arr[] = {2, 4, 8, 4};
        int arr[] = {2, 4, 4, 1, 2, 1};

        balancedPartition(arr);
    }

    public static int[] balancedPartition(int[] arr) {
        List<Integer> partition = new ArrayList<Integer>();
        int sum = 0;

        for (int d : arr) {
            sum += d;
        }

        if (sum % 2 != 0) {
            return null;
        }

        //boolean result = balancedPartitionRec(arr, arr.length - 1, sum / 2, partition);

        boolean result = findPartition(arr, sum);
        return null;
    }

    // DP Solution
    private static boolean findPartition(int[] arr, int sum) {
        int n = arr.length;
        int i, j;
        boolean[][] part = new boolean[(sum/2)+1][n+1];

        for (j = 0; j <= n; j++) {
            part[0][j] = true;
        }

        for (i = 1; i <= sum/2; i++) {
            part[i][0] = false;
        }

        for (i = 1; i <= sum/2; i++) {
            for (j = 1; j < n; j++) {
                part[i][j] = part[i][j-1];

                if (i >= arr[j-1]) {
                    part[i][j] = part[i][j] || part[(i - arr[j-1])][j-1];
                }
            }
        }

        for (i = 0; i <= sum/2; i++) {
            for (j = 0; j <= n; j++) {
                System.out.print(" " + part[i][j]);
            }
            System.out.println();
        }
        return part[sum/2][n];
    }

    // RECURSIVE Solution
    private static boolean balancedPartitionRec(int[] arr, int n, int sum, List<Integer> subSet) {
        if (sum == 0) {
            return true;
        }

        if (n <= 0) {
            return false;
        }

        boolean one = balancedPartitionRec(arr, n - 1, sum, subSet);

        subSet.add(arr[n-1]);
        boolean two = balancedPartitionRec(arr, n - 1, sum - arr[n - 1], subSet);

        if (!two) {
            subSet.remove(subSet.size() - 1);
        }

        return one || two;
    }
}
