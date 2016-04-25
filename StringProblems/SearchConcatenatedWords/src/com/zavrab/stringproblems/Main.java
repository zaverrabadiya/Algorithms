package com.zavrab.stringproblems;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String inStr = "dogthecatcatthedog";
        String[] words = {"the", "cat"};

        Integer[] result = concatSubstring(inStr, words);

        String output = "{";

        for (int i : result) {
            output += i + ", ";
        }
        output = output.substring(0, output.length() - 2);
        output += "}";
        System.out.print(output);
    }

    public static Integer[] concatSubstring(String inStr, String[] inWords) {

        if (inWords.length < 1 || inStr.length() < 1) {
            return null;
        }

        HashSet<Integer> wordsHash = calculateRollingHash(inWords);
        List<Integer> result = new ArrayList<Integer>();
        int k = inWords[0].length();
        int concatenateLen = k * inWords.length; // All words will be same length K
        int textHash = calculateRollingHash(inStr.substring(0, concatenateLen));

        int end = inStr.length() - concatenateLen;
        char left, right;

        if (wordsHash.contains(textHash)) {
            result.add(0);
        }

        for (int i = 1; i <= end; i++) {
            left = inStr.charAt(i - 1);
            right = inStr.charAt(i + concatenateLen - 1);
            textHash = updateRollingHash(textHash, left, right, concatenateLen);

            if (wordsHash.contains(textHash)) {
                result.add(i);
            }
        }

        return result.toArray(new Integer[result.size()]);
    }

    private static HashSet<Integer> calculateRollingHash(String[] words) {
        List<String> permutedWords = new ArrayList<String>();
        permuteWords(words, 0, permutedWords);

        HashSet<Integer> wordsHash = new HashSet<Integer>(permutedWords.size());
        for (String word : permutedWords) {
            int wordHash = calculateRollingHash(word);
            wordsHash.add(wordHash);
        }
        return wordsHash;
    }

    private static int calculateRollingHash(String str) {
        int hash = 0;

        // "daba" => 3 * 26^3 + 1 * 26^2 + 2 * 26^1 + 1 * 26^0

        for (int i = 0; i < str.length(); i++) {
            double power = (str.length() - 1) - i;
            int charInt = Character.toLowerCase(str.charAt(i)) - 'a' + 1;
            hash += (charInt * Math.pow(26.0, power));
        }

        return hash;
    }

    private static int updateRollingHash(int hash, char left, char right, int length) {

        // oldHash = "daba" => 3 * 26^3 + 1 * 26^2 + 2 * 26^1 + 1 * 26^0 = e.g. 2999

        // Update to "abac" add new character at end and remove one character from beginning
        // new Hash = "abac" => oldHash - (3 * 26^3), (oldHash * 26) + (2 * 26^0)
        double power = (length - 1);
        hash -= ((Character.toLowerCase(left) - 'a') + 1) * Math.pow(26, power);
        hash = (hash * 26) + ((Character.toLowerCase(right) - 'a') + 1);

        return hash >= 0 ? hash : hash + 31;
    }

    private static void permuteWords(String[] words, int start, List<String> result) {
        if (start == words.length - 1) {
            String permutedWords = "";
            for (String word : words) {
                permutedWords += word;
            }
            result.add(permutedWords);
        }

        for (int i = start; i < words.length; i++) {
            swap(words, start, i);
            permuteWords(words, start + 1, result);
            swap(words, i, start);
        }
    }

    private static void swap(String[] arr, int l, int r) {
        String temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
