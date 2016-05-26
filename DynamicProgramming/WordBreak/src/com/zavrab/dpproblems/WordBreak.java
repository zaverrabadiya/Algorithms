package com.zavrab.dpproblems;

import java.util.HashSet;

public class WordBreak {

    public static void main(String[] args) {
        String word = "applepie";
        String[] dict = {"apple", "pie", "let", "app"};

        System.out.print("Result: " + wordBreak(word, dict));
        //System.out.print("Result: " + canBreakTheStringIntoWords(word, dict));
    }


    // RECURSIVE Solution
    public static String wordBreak(String word, String[] dict) {
        HashSet<String> dictHashSet = createHashSetOfWordDictionary(dict);
        return wordBreak(word, dictHashSet);
    }

    private static String wordBreak(String word, HashSet<String> dictionary) {
        String partWord = "";

        for (int i = 1; i <= word.length(); i++) {
            partWord = word.substring(0, i);

            if (dictionary.contains(partWord)){
                String result = wordBreak(word.substring(i), dictionary);

                if (result != null) {
                    return partWord + " " + result;
                }
            }
        }

        if (dictionary.contains(partWord)) {
            return partWord;
        }

        return null;
    }

    // Only checks if string can be broken in dictionary words
    public static boolean canBreakTheStringIntoWords(String word, String[] strDict) {
        HashSet<String> dictHashSet = createHashSetOfWordDictionary(strDict);
        return canBreakTheStringIntoWords(word, dictHashSet);
    }

    private static boolean canBreakTheStringIntoWords(String strSentence, HashSet<String> dictionary) {
        if (strSentence.length() == 0) {
            return true;
        }

        for (int i = 1; i <= strSentence.length(); i++) {
            String word = strSentence.substring(0, i);
            if (dictionary.contains(word) &&
                    canBreakTheStringIntoWords(strSentence.substring(i), dictionary)) {
                return true;
            }
        }
        return false;
    }

    private static HashSet<String> createHashSetOfWordDictionary(String[] strDict){
        HashSet<String> hashDict = new HashSet<String>(strDict.length);

        for (String word : strDict) {
            hashDict.add(word);
        }

        return hashDict;
    }
}
