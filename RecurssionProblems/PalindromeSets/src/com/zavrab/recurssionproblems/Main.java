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
        String[] result = partition(input);
        for (String strings : result) {
            System.out.println(strings);
        }
    }


    public static String[] partition(String s) {
        List<String> result = new ArrayList<String>();

        if (s == null || s.length() == 0) {
            return null;
        }

        ArrayList<String> partition = new ArrayList<String>();//track each possible partition
        addPalindrome(s, 0, partition, result);
        String[] arr = result.toArray(new String[result.size()]);
        return arr;
    }

    private static void addPalindrome(String s, int start, ArrayList<String> partition,
                               List<String> result) {
        //stop condition
        if (start == s.length()) {
            ArrayList<String> temp = new ArrayList<String>(partition);
            String finalStr = String.join("|", temp);
            result.add(finalStr);
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if (isPalindrome(str)) {
                partition.add(str);
                addPalindrome(s, i, partition, result);
                partition.remove(partition.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
