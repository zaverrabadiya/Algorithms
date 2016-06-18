package com.zavrab.stringproblems;

import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        // Given a pattern and a string str, find if str follows the same pattern.
        // e.g.
        // pattern = "abba", str = "dog cat cat dog" => true.
        // pattern = "abba", str = "dog cat cat fish" => false.
        // pattern = "aaaa", str = "dog cat cat dog" => false.
        // pattern = "abba", str = "dog dog dog dog" => false.
        // pattern = "abab", str = "cat dog cat dog" => true

        String pattern = "abba", inStr = "dog cat cat fish";
        //System.out.print(isStrFollowsPattern(pattern, inStr));

        //    pattern = "abab", str = "redblueredblue" => true
        //    pattern = "aaaa", str = "asdasdasdasd" => true
        //    pattern = "aabb", str = "xyzabcxyzabc" => false

        String pattern2 = "hi", inStr2 = "zaver";
      //  System.out.print(isStrFollowsPatternNoSpace(pattern2, inStr2));

        //System.out.println(PatternMatch.checkPattern("abab","redblueredblue"));
        System.out.println(PatternMatch.match("abab","redblueredblue"));
//        System.out.println(checkPattern("aabb","xyzabcxzyabc"));

    }


    public static boolean isStrFollowsPattern(String pattern, String inStr) {
        // Bijection maps
        HashMap<String, Character> wordToPatternMap = new HashMap<String, Character>();
        HashMap<Character, String> patternToWordMap = new HashMap<Character, String>();

        int pIndx = 0;
        String word = "";

        for (int i = 0; i <= inStr.length(); i++) {

            if (i == inStr.length() || inStr.charAt(i) == ' ') {
                Character currentPattern = pattern.charAt(pIndx);
                String wordFromMap = patternToWordMap.get(currentPattern);
                Character patternFromMap = wordToPatternMap.get(word);

                // Check for word => pattern
                if (patternFromMap == null) {
                    wordToPatternMap.put(word, currentPattern);
                } else if (!currentPattern.equals(patternFromMap)) {
                    return false;
                }

                // Check for pattern => word
                if (wordFromMap == null) {
                    patternToWordMap.put(currentPattern, word);
                } else if (!word.equals(wordFromMap)) {
                    return false;
                }

                pIndx++;
                word = "";
            } else {
                word += inStr.charAt(i);
            }
        }

        return true;
    }


//    pattern = "abab", str = "redblueredblue" => true
//    pattern = "aaaa", str = "asdasdasdasd" => true
//    pattern = "aabb", str = "xyzabcxzyabc" => false

    public static boolean isStrFollowsPatternNoSpace(String pattern, String inStr) {
        // Bijection maps
        HashMap<String, Character> wordToPatternMap = new HashMap<String, Character>();
        HashMap<Character, String> patternToWordMap = new HashMap<Character, String>();

        int pIndx = 0, wIndx = 0;
        String word = "";

        //Find equal word length
        int halfLen = inStr.length() / 2;


        int leftLen = (halfLen / 2), rightLen = (halfLen - leftLen);
        boolean left = true;

        for (int i = 0; i <= inStr.length(); i++) {

            if (i == inStr.length() || (left && wIndx == leftLen) || (!left && wIndx == rightLen)) {
                Character currentPattern = pattern.charAt(pIndx);
                String wordFromMap = patternToWordMap.get(currentPattern);
                Character patternFromMap = wordToPatternMap.get(word);

                // Check for word => pattern
                if (patternFromMap == null) {
                    wordToPatternMap.put(word, currentPattern);
                } else if (!currentPattern.equals(patternFromMap)) {
                    return false;
                }

                // Check for pattern => word
                if (wordFromMap == null) {
                    patternToWordMap.put(currentPattern, word);
                } else if (!word.equals(wordFromMap)) {
                    return false;
                }

                pIndx++;
                left = !left;

                if (i < inStr.length()) {
                    word = "" + inStr.charAt(i);
                    wIndx = 1;
                }

            } else {
                word += inStr.charAt(i);
                wIndx++;
            }
        }

        return true;
    }
}
