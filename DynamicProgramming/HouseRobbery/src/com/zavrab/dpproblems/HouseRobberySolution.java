package com.zavrab.dpproblems;

/**
 * http://codercareer.blogspot.com/2013/02/no-44-maximal-stolen-values.html
 *
 * Problem: There are n houses built in a line, each of which contains some value in it.
 * A thief is going to steal the maximal value in these houses,
 * but he cannot steal in two adjacent houses because the owner of a stolen house will tell his two neighbors on the left and right side.
 * What is the maximal stolen value?
 *
 * Houses: {6, 1, 2, 7, 1}; // Output: 13
 * */
public class HouseRobberySolution {

    public static void main(String[] args) {
        int[] houseValues = new int[] {6, 1, 2, 7, 1}; // Output: 13
        System.out.println("Maximal robbery: " + maxStolenValue(houseValues));

        int[] houseValues2 = new int[] {1, 2, 3, 4, 5}; // Output: 9
        System.out.println("Maximal robbery: " + maxStolenValue(houseValues2));

        int[] houseValues3 = new int[] {10, 2, 3, 4, 5, 6}; // Output: 20
        System.out.println("Maximal robbery: " + maxStolenValue(houseValues3));

        int[] houseValues4 = new int[] {10, 2, 3, 4, 20, 6}; // Output: 33
        System.out.println("Maximal robbery: " + maxStolenValue(houseValues4));
    }

    public static int maxStolenValue(int[] arrHouseValues) {
        //return maxStolenValueInternal(arrHouseValues, 0);
        return maxStolen(arrHouseValues);
    }

    // DP solution
    private static int maxStolen(int[] houseValues) {
        if (houseValues.length == 0) {
            return 0;
        }

        int value1 = houseValues[0];
        if (houseValues.length == 1) {
            return value1;
        }

        int value2 = Math.max(value1, houseValues[1]);
        if (houseValues.length == 2) {
            return value2;
        }

        int value = 0;

        for (int i = 2; i < houseValues.length; i++) {
            value = Math.max(value2, value1 + houseValues[i]); // Can add to 1st value and curr element because first is h[0] and i = 2
            value1 = value2; // First gets second's value because i is increasing to 3
            value2 = value;
        }

        return value;
    }

    // RECURSIVE
    private static int maxStolenValueInternal(int[] houseValues, int start) {
        if (start >= houseValues.length) {
            return 0;
        }

        int first = houseValues[start] + maxStolenValueInternal(houseValues, start + 2);
        int second = maxStolenValueInternal(houseValues, start + 1);

        return Math.max(first, second);
    }
}
