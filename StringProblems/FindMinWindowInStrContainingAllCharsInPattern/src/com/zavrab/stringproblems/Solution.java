package com.zavrab.stringproblems;

//http://articles.leetcode.com/finding-minimum-window-in-s-which/

public class Solution {

    public static void main(String[] args) {
        System.out.println(findMinWindowWhichContainsAllCharsInPattern("ADOBECODEBANC", "ABC"));
        System.out.println(findMinWindowWhichContainsAllCharsInPattern("ADOBECODEBANC", "BN"));
    }

    public static String findMinWindowWhichContainsAllCharsInPattern(String inStr, String pattern) {
        //Count number of characters in pattern
        int[] needToFind = prePopulateArray(pattern);
        int[] hasFound = new int[256];
        int i = 0, count = 0, minLen = Integer.MAX_VALUE, windowStartPos = -1, windowEndPos = -1;

        for (int j = 0; j < inStr.length(); j++) {
            char currChar = inStr.charAt(j);

            // Check if current char is in pattern; 0 count means no need to find
            if (needToFind[currChar] == 0) {
                continue;
            }

            // Increase current character count
            hasFound[currChar]++;

            // Total character found, this check makes sure that only one repeating character does not lead to increasing the entire count
            // e.g. "aaaaabbbcc" and "ac": without this check 'a' will bump up the whole count
            if (hasFound[currChar] <= needToFind[currChar]) {
                count++;
            }

            // If found all the characters in pattern
            if (count == pattern.length()) {
                currChar = inStr.charAt(i);

                // Advance the begin pointer till found characters are more than needed to find
                // or do not need to find the current character from string.
                while (i < j && (needToFind[currChar] == 0 || (hasFound[currChar] > needToFind[currChar]))) {
                    if (hasFound[currChar] > needToFind[currChar]) {
                        hasFound[currChar]--;
                    }

                    i++;
                    currChar = inStr.charAt(i);
                }

                // Update the minimum window-length
                int windowLength = (j - i) + 1;
                if (windowLength < minLen) {
                    minLen = windowLength;
                    windowStartPos = i;
                    windowEndPos = j;
                }
            }
        }

        // If found valid start and end points then return the substring from start to end points
        if (windowStartPos != -1 && windowEndPos != -1) {
            return inStr.substring(windowStartPos, windowEndPos + 1);
        }

        return null;
    }

    private static int[] prePopulateArray(String str) {
        int[] arr = new int[256];

        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)]++;
        }
        return arr;
    }
}
