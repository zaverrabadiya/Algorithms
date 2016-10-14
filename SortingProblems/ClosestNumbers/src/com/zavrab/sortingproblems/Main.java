package com.zavrab.sortingproblems;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] input = new int[]{-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854};
        String result = closestNumbers(input);

        System.out.print(result);
    }

    public static String closestNumbers(int[] inArray) {
        int minDistance = Integer.MAX_VALUE;
        String output = "";

        if (inArray == null || inArray.length == 0) {
            return output;
        }

        if (inArray.length == 1) {
            return output + inArray[0];
        }

        // Sort the input array
        Arrays.sort(inArray);

        for (int i = 0; i < inArray.length - 1; i++) {
            int distance = Math.abs(inArray[i] - inArray[i + 1]);

            if (distance < minDistance) {
                output = inArray[i] + " " + inArray[i + 1];
                minDistance = distance;
            } else if (distance == minDistance) {
                output += " " + inArray[i] + " " + inArray[i + 1];
            }
        }

        return output;
    }
}
