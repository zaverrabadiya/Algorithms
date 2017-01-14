package com.zavrab.stringproblems;

import java.util.ArrayList;
import java.util.List;

public class FindIndicesOfAllAnagrams {

    public static void main(String[] args) {
        String s = "cbdaefabdc";
        String p = "abcd";

        for (int i : findIndicesOfAllAnagrams(s, p)) {
            System.out.print(i + " ");
        }

        s = "aaabababc";
        p = "ab";

        System.out.println();
        for (int i : findIndicesOfAllAnagrams(s, p)) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> findIndicesOfAllAnagrams(String s, String p) {
        List<Integer> indices = new ArrayList<Integer>();
        int totalFound = 0, leftPosition = -1;
        int[] hasFound = new int[256];

        // Pre-populate the character count from pattern p to find from string s
        int[] needToFind = countCharactersToFind(p);

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);

            if (needToFind[c] == 0 && totalFound > 0) {
                // Reset everything when-- out of the pattern character found
                resetHasFound(hasFound);
                totalFound = 0;
                leftPosition = -1;
                continue;
            }

            // Increase found character count
            hasFound[c]++;

            // Set left only once when first character matches
            if (leftPosition == -1) {
                leftPosition = i;
            }

            // Total character found, this check makes sure that only one repeating character does not lead to increasing the entire count
            // e.g. "aaaaabbbcc" and "ac": without this check 'a' will bump up the whole count
            if (hasFound[c] <= needToFind[c]) {
                totalFound++;
            }

            if (totalFound == p.length()) {
                int leftChar = s.charAt(leftPosition);

                // Remove extra repeating characters from left
                while (hasFound[leftChar] > needToFind[leftChar]) {
                    hasFound[leftChar]--;
                    leftPosition++;
                }

                indices.add(leftPosition++);

                // Reset left character count to drop it from the current result, so we can add next character at end to form the result again
                hasFound[leftChar]--;
                totalFound--;
            }
        }

        return indices;
    }

    private static void resetHasFound(int[] hasFound) {
        for (int i = 0; i < hasFound.length; i++) {
            hasFound[i] = 0;
        }
    }

    private static int[] countCharactersToFind(String str) {
        int[] arr = new int[256];

        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)]++;
        }
        return arr;
    }
}
