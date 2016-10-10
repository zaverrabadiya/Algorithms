package com.zavrab.recurssionproblems;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] set = new int[] {1, 2, 3};
        printSubsets(set);
    }

    public static void printSubsets(int[] set) {
        List<Integer> subset = new ArrayList<Integer>(set.length);
        printSubsets(set, 0, subset);
    }

    private static void printSubsets(int[] set, int i, List<Integer> subset){

        if (i == set.length) {
            System.out.print("{");

            for (int k = 0; k < subset.size(); k++) {
                System.out.print(subset.get(k));
            }

            System.out.print("}");
            System.out.println();

            return;
        }

        // Recurse
        printSubsets(set, i + 1,  subset); //Do not pick anything

        // Pick one before recursion
        subset.add(set[i]);

        // Recurse
        printSubsets(set, i + 1, subset);

        // Drop the last one after recursion
        subset.remove(subset.size() - 1);
    }
}
