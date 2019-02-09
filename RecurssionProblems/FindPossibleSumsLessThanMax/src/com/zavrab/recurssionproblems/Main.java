package com.zavrab.recurssionproblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import static java.util.stream.Collectors.toList;

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

        List<Integer> recursionResult = getPossibleCombination(a, max);

        recursionResult.stream().sorted().forEach(i -> System.out.print(i + ", "));

        System.out.println();

        Set<Integer> permutedResult = new HashSet<>();
        sum(a, 0, new ArrayList<>(), max, permutedResult);
        permutedResult.stream().sorted().forEach(i -> System.out.print(i + ", "));
    }

    public static List<Integer> getPossibleCombination(int[] a, int max) {
        if (a == null || a.length == 0) {
            return      null;
        }

        List<Integer> result = new ArrayList<Integer>();

        recHelper(a, 0, result, new ArrayList<>(), max);


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

    private static void sum(int[] a, int i, List<Integer> parts, int max, Set<Integer> result) {
        final List<Integer> permutes = permute(parts);
        boolean hasValidSum = permutes.stream().anyMatch( r -> r <= max);

        if (i == a.length || permutes.size() > 0 && !hasValidSum) {
            return;
        }

        result.addAll(permutes.stream().filter(f -> f <= max).collect(toList()));

        sum(a, i + 1, parts, max, result);
        parts.add(a[i]);

        sum(a, i, parts, max, result);

        sum(a, i + 1, parts, max, result);
        parts.remove(parts.size() - 1);
    }

    private static List<Integer> permute(List<Integer> sum) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < sum.size(); i++) {
            permute(sum, i, result);
        }

        return result;
    }

    private static void permute(List<Integer> sum, int i, List<Integer> result) {
        if (i == sum.size()) {
            return;
        }

        for (int j = i; j < sum.size(); j++) {
            swap(sum, i, j, result);
            permute(sum, i + 1, result);
            swap(sum, i, j, result);
        }
    }

    private static void swap(List<Integer> sum, int i, int j, List<Integer> result) {
        int t = sum.get(i);
        sum.set(i, sum.get(j));
        sum.set(j, t);

        int intSum = getSum(sum);

        result.add(intSum);
    }
}
