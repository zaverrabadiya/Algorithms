package com.zavrab.recurssionproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
* Print all possibilities for given number that maps to the string
* Print should be in order as number
*
* */
public class Main {

    private static HashMap<Integer, String> pad = new HashMap<Integer, String>(10);

    static {
        pad.put(1, "ABC");
        pad.put(2, "DEF");
        pad.put(3, "GHI");
        pad.put(4, "JKL");
        pad.put(5, "MNO");
        pad.put(6, "PQR");
        pad.put(7, "STU");
        pad.put(8, "VWX");
        pad.put(9, "YZ");
        pad.put(0, "*+#");
    }

    public static void main(String[] args) {
        printPossibilities(215, pad);
    }

    public static void printPossibilities(int n, HashMap<Integer, String> pad) {
        List<Integer> nums = parseNumber(n);
        printPossibilities(nums, pad, nums.size()-1, new StringBuilder());
    }

    private static List<Integer> parseNumber(int n) {
        List<Integer> result = new ArrayList<Integer>();

        while (n > 0) {
            int i = n % 10;
            n = n/10;

            result.add(i);
        }

        return result;
    }

    private static void printPossibilities(List<Integer> nums, HashMap<Integer, String> pad, int start, StringBuilder result) {
        if (start < 0) {
            System.out.println(result.toString());
            return;
        }

        //Get the string for number at position: start
        int currNum = nums.get(start);
        String currentStr = pad.get(currNum);

        for (int i = 0; i < currentStr.length(); i++) {
            StringBuilder intermediateResult = new StringBuilder(result);
            intermediateResult.append(currentStr.charAt(i));

            printPossibilities(nums, pad, start-1, intermediateResult);
        }
    }
}
