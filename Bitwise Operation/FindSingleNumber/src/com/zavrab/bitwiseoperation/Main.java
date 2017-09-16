package com.zavrab.bitwiseoperation;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/single-number-iii/#/description
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
 * Find the two elements that appear only once.

 * For example:

 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 *
 * */
public class Main {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 2, 6, 1};
        System.out.print(Arrays.toString(singleNumber(nums)));
    }

    public static int[] singleNumber(int[] nums) {
        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get its last set bit
        diff &= -diff;

        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums)
        {
            if ((num & diff) == 0) // the bit is not set
            {
                rets[0] ^= num;
            }
            else // the bit is set
            {
                rets[1] ^= num;
            }
        }
        return rets;
    }
}
