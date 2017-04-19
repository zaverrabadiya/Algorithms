package com.zavrab.dpproblems;

/**
 * And we can construct the solution in bottom up manner such that every filled entry has following property
 * part[i][j] = true if a subset of {arr[0], arr[1], ..arr[j-1]} has sum equal to i, otherwise false
 *
 * http://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/
 *
 * */

public class BalancedPartitionSolution {

    public static void main(String[] args) {
        //int arr[] = {3, 1, 5, 9, 12};
        //int arr[] = {2, 4, 8, 4};
        int arr[] = {2, 4, 4, 1, 2, 1};

        boolean result = balancedPartition(arr);

        System.out.println("\nIs balanced partition: " + result);
    }

    public static boolean balancedPartition(int[] arr) {
        int sum = 0;

        for (int d : arr) {
            sum += d;
        }

        if (sum % 2 != 0) {
            return false;
        }

        //boolean result = balancedPartitionRec(arr, arr.length - 1, sum / 2);

        return findPartition(arr, sum);
    }

    // DP Solution
    private static boolean findPartition(int[] arr, int sum) {
        int n = arr.length;
        int i, j;
        boolean[][] part = new boolean[(sum/2)+1][n+1];

        for (j = 0; j <= n; j++) {
            part[0][j] = true;
        }

        for (i = 1; i <= sum/2; i++) {  // SUM

            for (j = 1; j <= n; j++) {  // Array element

                // Carry forward the result of previous element for the same sum-- i
                part[i][j] = part[i][j-1];

                if (i >= arr[j-1]) {
                    // Check the status of current sum - current element e.g. i = 3, element = 1 then see whats the status of 3-1 = sum-- 2
                    // part[i - currentElement][j-1]: here j-1 in result table to make sure that sum was true with elements before the current element
                    //e.g sum:3 element:1 means see if we have sum 2 within 0..j-1  elements
                    // OR carry the status from previous element

                    part[i][j] = part[i][j] || part[(i - arr[j-1])][j-1];
                }
            }
        }


        // JUST FOR DEBUG PURPOSE =================
        System.out.println("Table for debug:");

        for (i = 0; i <= sum/2; i++) {
            for (j = 0; j <= n; j++) {
                System.out.print(part[i][j] + "\t");
            }

            System.out.println();
        }
        // DEBUG END =================================

        return part[sum/2][n];
    }

    // RECURSIVE Solution
    private static boolean balancedPartitionRec(int[] arr, int n, int sum) {
        if (sum == 0) {
            return true;
        }

        if (n <= 0) {
            return false;
        }

        boolean one = balancedPartitionRec(arr, n - 1, sum);

        boolean two = balancedPartitionRec(arr, n - 1, sum - arr[n]);

        return one || two;
    }
}
