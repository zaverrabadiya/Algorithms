package com.zavrab.stringproblems;

public class Main {

    public static void main(String[] args) {
        // e.g.
        // "abaabab" => "aaaabbb" swaps: 2
        // "baab" => "aaab" swaps: 1
        // "abba" => "abbb" swaps: 1
        // "bbbaa" => "bbbbb" swaps: 2
        // "ababaa" => "aaaaaa" swaps: 2
        // "bababb" => "bbbbbb" swaps: 2

        String input = "abaabab";
        System.out.format("Min swap output: %s => %s", input, validStringWithMinReplacements(input));
    }

    public static String validStringWithMinReplacements(String inStr) {

        if (inStr == null || inStr.isEmpty()) {
            return inStr;
        }

        int numOfAs = 0, numOfBs = 0, totalSwaps = 0, minSwaps = Integer.MAX_VALUE, minIndex = 0;

        // Find number of a's
        for (int i = 0; i < inStr.length(); i++) {
            if (inStr.charAt(i) == 'a') {
                ++numOfAs;
            }
        }

        // Find min swap at every element by comparing total b's before and a's after the current element
        for (int j = 0; j < inStr.length(); j++) {
            if (inStr.charAt(j) == 'a') {
                totalSwaps = numOfBs + (--numOfAs); // Decrease 'a' since it is current and need not to replace with 'b'

                if (totalSwaps < minSwaps) {
                    minSwaps = totalSwaps;
                    minIndex = j;
                }
            } else {
                totalSwaps = numOfBs + numOfAs;

                if (totalSwaps < minSwaps) {
                    minSwaps = totalSwaps;
                    minIndex = j;
                }
                numOfBs++; // Increase 'b' since moving to right
            }
        }

        return swap(inStr, 'a', 0, minIndex) // Replace 'b' with 'a' on left side
            + inStr.charAt(minIndex)         // Include mid element who does not need to replaced with anything
            + swap(inStr, 'b', minIndex + 1, inStr.length()); // Replace 'a' with 'b' on right side
    }

    private static String swap(String inStr, char c, int s, int e) {
        char[] chars = inStr.substring(s, e).toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != c) {
                chars[i] = c;
            }
        }
        return new String(chars);
    }
}
