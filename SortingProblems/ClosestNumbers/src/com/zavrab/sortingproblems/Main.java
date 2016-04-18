package com.zavrab.sortingproblems;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String input = "-20 -3916237 -357920 -3620601 7374819 -7330761 30 6246457 -6461594 266854";
        String result = closestNumbers(10, input);

        System.out.print(result);
    }

    public static String closestNumbers(int n, String s) {
        int minDistance = Integer.MAX_VALUE;
        String output = "";
        if (n <= 1) {
            return s;
        }
        int[] numbers = convertStringToIntArray(s);
        Arrays.sort(numbers);

        for (int i = 0; i < n - 1; i++) {
            int distance = Math.abs(numbers[i] - numbers[i + 1]);
            if (distance < minDistance) {
                output = numbers[i] + " " + numbers[i + 1];
                minDistance = distance;
            } else if (distance == minDistance) {
                output += " " + numbers[i] + " " + numbers[i + 1];
            }
        }
        return output;
    }

    private static int[] convertStringToIntArray(String s) {
        String[] strNumbers = s.split(" ");
        int[] result = new int[strNumbers.length];

        for (int i = 0; i < strNumbers.length; i++) {
            result[i] = Integer.valueOf(strNumbers[i]);
        }
        return result;
    }

}
