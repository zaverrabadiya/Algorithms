package com.zavrab.stringproblems;

public class Main {

    public static void main(String[] args) {
        // Find longest palindromic string using Manacher's algorithm
        //e.g.
        // "ababbaba" => "ababbaba"
        // "bbabbaba" => "babbab"
        // "desserts" => "esse"
        // "banananobano" => "anana"

        String inStr = "banananobano";

        String maxPalindrome = findLongestPalindromicSubString(inStr);
        System.out.print("Longest Palindrome: " + maxPalindrome);
    }

    public static String findLongestPalindromicSubString(String inStr) {
        char[] charArray = convertToTempCharArry(inStr);
        int[] p = new int[charArray.length];
        int center = 1, rEdge = 1;

        for (int i = 1; i < charArray.length - 1; i++) {
            int mirror = (2 * center) - i;

            if (i < rEdge) {
                p[i] = Math.min(p[mirror], rEdge - i);
            }

            while (Character.toLowerCase(charArray[i + (p[i] + 1)]) == Character.toLowerCase(charArray[i - (p[i] + 1)])) {
                ++p[i];
            }

            if (p[i] + i > rEdge) {
                center = i;
                rEdge = p[i] + i;
            }
        }

        return getSubstring(inStr, p);
    }

    private static char[] convertToTempCharArry(String s) {
        char[] charArray = new char[s.length() * 2 + 3];
        charArray[0] = '@'; //Starting unique char
        int j = 1;
        for (int i = 0; i < s.length(); i++) {
            charArray[j++] = '#';
            charArray[j++] = s.charAt(i);
        }
        charArray[j++] = '#';
        charArray[j] = '$'; //Ending unique char

        return charArray;
    }

    private static String getSubstring(String s, int[] p) {
        //Find max element
        int max = Integer.MIN_VALUE, maxElementIdx = 0;

        for (int i = 0; i < p.length; i++) {
            if (p[i] > max) {
                max = p[i];
                maxElementIdx = i;
            }
        }

        int actualIdxInString = (maxElementIdx / 2) - (maxElementIdx % 2 == 1? 0 : 1);
        int startIdx = actualIdxInString - (max / 2);
        return s.substring(startIdx, (max == s.length()? max : max + 1));
    }
}
