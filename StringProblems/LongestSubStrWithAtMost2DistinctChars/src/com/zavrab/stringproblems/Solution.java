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
        int subStrFrom = 0, currLen = 0, maxLen = 0, startPos = 0, count = 0;
        char currChar;

        for (int i = 0; i < strText.length(); i++) {
            currChar = strText.charAt(i);

            count = distChars.containsKey(currChar) ? count + 1 : 1;
            distChars.put(currChar, count);

            if (distChars.size() > 2) {
                currLen = i - startPos;

                if (currLen > maxLen) {
                    maxLen = currLen;
                    subStrFrom = startPos;
                }

                while (distChars.size() > 2) {
                    char c1 = strText.charAt(startPos);
                    count = distChars.get(c1);

                    if (count > 1) {
                        distChars.put(c1, --count);
                    } else {
                        distChars.remove(c1);
                    }

                    startPos++;
                }
            }
        }

        // Suppose whole string or last substring contains only 2 distinct characters
        // then if (distChars.size() > 2) won't be executed
        currLen = strText.length() - startPos;

        if (currLen > maxLen && distChars.size() > 1) {
            maxLen = currLen;
            subStrFrom = startPos;
        }

        return (maxLen > 0)? strText.substring(subStrFrom, (subStrFrom + maxLen)) : "";
    }
}
