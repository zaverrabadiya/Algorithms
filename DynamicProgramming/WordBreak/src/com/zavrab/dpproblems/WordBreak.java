package com.zavrab.dpproblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

// http://www.geeksforgeeks.org/dynamic-programming-set-32-word-break-problem/
public class WordBreak {

    public static void main(String[] args) {
        String sentence = "applepie";
        String[] dict = {"apple", "pie", "let", "app"};

        String sentence2 = "interviewkickstart";
        String[] dict2 = {"a", "e", "i", "int", "inter", "interview", "kick", "kicker", "kickstart", "star", "start", "view"};

        String sentence3 = "interviewkickstart";
        String[] dict3 = {"interview", "kick", "kstart", "kicks"};

        String sentence4 = "catsdogcats";
        String[] dict4 = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};

        System.out.print("Result: " + wordBreakRec(sentence4, dict4));

//        String result[] = canBreakTheStringIntoWordsDp(sentence, dict);
//        if (result != null) {
//            System.out.println("Words broken from the given sentence: ");
//
//            for (String word : result) {
//                System.out.print(word + " ");
//            }
//        } else {
//            System.out.println("Could not break the sentence into dictionary words!");
//        }
    }

    // DP Solution
    public static String[] canBreakTheStringIntoWordsDp(String strInput, String[] dict) {
        if (strInput.length() == 0) {
            return null;
        }

        HashSet<String> dictionary = createHashSetOfWordDictionary(dict);
        boolean[] cache = new boolean[strInput.length() + 1];
        boolean done = false;

        for (int i = 1; i <= strInput.length() && !done; i++) {

            // if cache[i] is false, then check if current prefix can make it true.
            // Current prefix is "str.substr(0, i)"
            if (!cache[i] && dictionary.contains(strInput.substring(0, i))) {
                cache[i] = true;
            }

            // cache[i] is true, then check for all substrings starting from
            // (i+1)th character and store their results.
            if (cache[i]) {

                if (i == strInput.length()) {
                    break;
                }

                for (int j = i + 1; j <= strInput.length(); j++) {
                    String word = strInput.substring(i, j);

                    if (!cache[j] && dictionary.contains(word)) {
                        cache[j] = true;
                    }

                    if (j == strInput.length() && cache[j]) {
                        done = true;
                    }
                }
            }

        }

        return done ? findWordsUsingCacheAndDict(cache, strInput, dictionary) : null;
    }

    private static String[] findWordsUsingCacheAndDict(boolean[] cache, String sentence, HashSet<String> dictionary) {
        List<String> words = new ArrayList<String>();
        String word;
        int lastIdx = sentence.length();

        for (int i = sentence.length(); i >= 0; i--) {

            if (cache[i] || i == 0) {
                word = sentence.substring(i, lastIdx);

                if (dictionary.contains(word)) {
                    words.add(word);
                    lastIdx = i;
                }
            }
        }

        Collections.reverse(words);
        return words.toArray(new String[words.size()]);
    }

    // RECURSIVE Solution ==============================================================================================
    public static String wordBreakRec(String word, String[] dict) {
        HashSet<String> dictHashSet = createHashSetOfWordDictionary(dict);
        return wordBreakRecInternal(word, dictHashSet);
    }

    private static String wordBreakRecInternal(String word, HashSet<String> dictionary) {
        String partWord = "";

        for (int i = 1; i <= word.length(); i++) {
            partWord = word.substring(0, i);

            if (dictionary.contains(partWord)){
                String result = wordBreakRecInternal(word.substring(i), dictionary);

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

            if (dictionary.contains(word)
                    && canBreakTheStringIntoWords(strSentence.substring(i), dictionary)) {
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
