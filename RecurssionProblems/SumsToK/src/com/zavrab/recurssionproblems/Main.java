package com.zavrab.recurssionproblems;

public class Main {

    public static void main(String[] args) {
        // Given an array of integers, find all TRIPLETS that sum to a given integer 0
        // e.g.
        // Input = {2, 4, 8}, 6 => true
        // Input = { 2, -4, 8 }, 1 => false
        // Input = {2, 4, 8}, 2 => true

        int[] input = {2, 4, 8};

        System.out.print("Result: " + isSumK(input, 14));
    }

    public static boolean isSumK(int[] inArray, int k) {

        return isSumK(inArray, 0, k);
    }

    private static boolean isSumK(int[] arr, int s, int sum) {

        if (sum == 0) {
            return true;
        }

        if (s == arr.length) {
            return false;
        }

        return isSumK(arr, s + 1, sum)  // Skip the current-element
                || isSumK(arr, s + 1, sum - arr[s]);  // Reduces the current-element from sum and picks next element in array
    }
}
