package com.zavrab.arrayproblems;

/***
 * Find longest increasing SUB-ARRAY length (Don't be confused with SUB-SEQUENCE)
 *
 * A : {1, 6, 2, 4, 5} => 3
 * A : {1, 2, 4, 6, 8, 3} => 5
 * A : {1} => 1
 * A : {2, 2} => 1
 */
public class Main {

    public static void main(String[] args) {
        int[] a = new int[] {1, 6, 2, 4, 5};

        System.out.println("Max length: " + findLongestIncreasingSubArrayLength(a));
    }

    public static int findLongestIncreasingSubArrayLength(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }

        int max = 1, temp = 1;

        for (int i = 0; i < a.length-1; i++) {

            if (a[i] < a[i+1]) {
                temp++;
            }
            else {
                max = Math.max(max, temp);
                temp = 1;
            }
        }

        // To cover last element temp increment
        max = Math.max(max, temp);

        return max;
    }
}
