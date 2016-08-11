package com.zavrab.recurssionproblems;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //e.g.
        // "aaa"
        // a|a|a
        // a|aa
        // aa|a
        // aaa
        //
        // "desserts"
        // d|e|s|s|e|r|t|s
        // d|e|ss|e|r|t|s
        // d|esse|r|t|s
        String input = "desserts";
        String[] result = palindromicDecomposition(input);
        for (String strings : result) {
            System.out.println(strings);
        }
    }


    public static String[] palindromicDecomposition(String s) {
        List<String> result = new ArrayList<String>();

        if (s == null || s.length() == 0) {
            return null;
        }

        decomposePalindrome(s, 0, new StringBuilder(), result);
        return result.toArray(new String[result.size()]);
    }

    private static void decomposePalindrome(String s, int start, StringBuilder partition, List<String> result) {
        //stop condition
        if (start == s.length()) {
            result.add(partition.toString());
        }

        int replaceStartAt;

        for (int i = start + 1; i <= s.length(); i++) {
            String subStr = s.substring(start, i);

            if (isPalindrome(subStr)) {
                partition.append(subStr);
                partition.append("|");

                decomposePalindrome(s, i, partition, result);

                replaceStartAt = partition.length() - (subStr.length() + 1);
                partition.replace(replaceStartAt, partition.length(), "");
            }
        }
    }

    private static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }

        return (i >= j);
    }
}