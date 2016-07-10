package com.zavrab.stringproblems;

import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        System.out.println("Result: " + longestSubStrWithAtMost2DistinctChars("abbatxu"));  // => abba
        System.out.println("Result: " + longestSubStrWithAtMost2DistinctChars("aaabbbbb"));  // => aaabbbbb
        System.out.println("Result: " + longestSubStrWithAtMost2DistinctChars("abbaxxxxxxx"));  // => axxxxxxx
        System.out.println("Result: " + longestSubStrWithAtMost2DistinctChars("eceba"));  // => ece
        System.out.println("Result: " + longestSubStrWithAtMost2DistinctChars("tttt"));  // => ""
    }

    public static String longestSubStrWithAtMost2DistinctChars(String strText) {
        HashMap<Character, Integer> distChars = new HashMap<Character, Integer>();
        int subStrFrom = 0, maxLen = 0, startPos = 0;

        for (int i = 0; i < strText.length(); i++) {
            char c = strText.charAt(i);

            if (distChars.containsKey(c)) {
                int count = distChars.get(c);
                distChars.put(c, ++count);
            } else {
                distChars.put(c, 1);
            }

            if (distChars.size() > 2) {
                int currLen = i - startPos;
                if (currLen > maxLen) {
                    maxLen = currLen;
                    subStrFrom = startPos;
                }

                while (distChars.size() > 2) {
                    char c1 = strText.charAt(startPos);
                    int count = distChars.get(c1);

                    if (count > 1) {
                        distChars.put(c1, --count);
                    } else {
                        distChars.remove(c1);
                    }
                    startPos++;
                }
            }
        }

        int currLen = strText.length() - startPos;
        if (currLen > maxLen && distChars.size() > 1) {
            maxLen = currLen;
            subStrFrom = startPos;
        }

        if (maxLen > 0) {
            return strText.substring(subStrFrom, (subStrFrom + maxLen));
        }

        return "";
    }
}
