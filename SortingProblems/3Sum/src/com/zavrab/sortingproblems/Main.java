package com.zavrab.sortingproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    // Given an array of integers, find all TRIPLETS that sum to a given integer 0
        // e.g.
        // Input = {-1, 0, 1, 2, -1, -4}
        // Output = {-1, 0, 1}, {-1, -1, 2}

        int[] input = {-1, 0, 1, 2, -1, -4};

        String[] triplets = findTriplets(input);

        for (int i = 0; i < triplets.length; i++) {
            System.out.println(triplets[i]);
        }
    }

    public static String[] findTriplets(int[] inArray) {

        if (inArray == null || inArray.length < 3) {
            return new String[0];
        }

        Arrays.sort(inArray);

        List<String> result = new ArrayList<String>();
        for (int i = 0; i < inArray.length - 2; i++) {
            if (i > 0 && inArray[i] == inArray[i - 1]) {
                continue;
            }

            int negNumber = - inArray[i];
            int s = i + 1, e = inArray.length - 1;

            while (s < e) {
                if (inArray[s] + inArray[e] == negNumber) {
                    String str = inArray[i] + ", " + inArray[s] + ", " + inArray[e];
                    result.add(str);
                    s++;
                    e--;

                    while (s < e && inArray[s] == inArray[s + 1]) {
                        s++;
                    }

                    while (s < e && inArray[e] == inArray[e - 1]) {
                        e--;
                    }
                } else if (inArray[s] + inArray[e] < negNumber) {
                    s++;
                } else {
                    e--;
                }
            }
        }
        return result.toArray(new String[result.size()]);
    }
}
