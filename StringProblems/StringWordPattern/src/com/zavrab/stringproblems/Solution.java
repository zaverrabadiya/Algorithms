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
        System.out.println(matchWithSpace(pattern, inStr));

        //Given a pattern and a string str, find if str follows the same pattern. NO SPACE IN STRING
        //    pattern = "abab", str = "redblueredblue" => true
        //    pattern = "aaaa", str = "asdasdasdasd" => true
        //    pattern = "aabb", str = "xyzabcxyzabc" => false

        System.out.println(matchNoSpace("abab","redblueredblue"));
        System.out.println(matchNoSpace("aabb","xyzabcxzyabc"));

    }


    public static boolean matchWithSpace(String pattern, String inStr) {
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

    private static HashMap<Character, String> map;

    public static boolean matchNoSpace(String pattern, String str) {
        map = new HashMap<Character, String>();
        boolean res = matchNoSpaceRec(pattern, str);
        return res;
    }

    private static boolean matchNoSpaceRec(String pattern, String str) {
        if (pattern.length() == 0) {
            return str.length() == 0;
        }

        char pch = pattern.charAt(0);

        for (int i = 0; i < str.length(); ++i) {

            if (!map.containsKey(pch)) {
                String val = str.substring(0, i + 1);
                map.put(pch, val);

                if (matchNoSpaceRec(pattern.substring(1), str.substring(val.length()))) {
                    return true;
                } else {
                    map.remove(pch);
                }

            } else {
                String val = map.get(pch);

                if (!str.startsWith(val)) {
                    return false;
                }

                return matchNoSpaceRec(pattern.substring(1), str.substring(val.length()));
            }
        }
        return false;
    }
}
