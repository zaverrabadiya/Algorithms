package com.zavrab.recurssionproblems;

import java.util.ArrayList;
import java.util.List;

/**
 *  Given array of integers and and max number, find numbers from array whose sum is less than max number.
 *  input: {3, 7, 8, 5000},  1000
 *  output: 3, 33, 333, 37, 337, 378, 873, 877... etc...
 *
 *
 * */
public class Main {

    public static void main(String[] args) {
        int[] a = new int[]{3, 7, 8};
        int max = 1000;

        List<Integer> result = getPossibleCombination(a, max);

        for (Integer r : result) {
            System.out.println(r);
        }
    }

    public static List<Integer> getPossibleCombination(int[] a, int max) {
        if (a == null || a.length == 0) {
            return      null;
        }

        List<Integer> result = new ArrayList<Integer>();

        recHelper(a, 0, result, new ArrayList<Integer>(), max);

        return result;
    }

    private static void recHelper(int[] a, int i, List<Integer> result, List<Integer> part, int max) {

        int sum = getSum(part);

        if (sum > 0 && sum < max && !result.contains(sum)) {
            result.add(sum);
        }

        if (i == a.length || sum > max) {
            return;
        }

        // Skip ith
        recHelper(a, i + 1, result, part, max);

        // Add ith
        part.add(a[i]);

        // Keep adding same one at i
        recHelper(a, i, result, part, max);

        // Add elements previous to ith (start from i to 0)
        while (i >= 0) {
            recHelper(a, i, result, part, max);
            i--;
        }

        // Remove last one
        part.remove(part.size() - 1);
    }


    private static int getSum(List<Integer> a){
        int num = 0;

        for (Integer i : a) {
            num *= 10;
            num += i;
        }

        return num;
    }
}
