package com.zavrab.stringproblems;

public class RegexMatcher {

    public static void main(String[] args) {

        // Regular Expression matching
        // '.' Matches any single character
        // '*' Matches any zero or more of the preceding character

        // e.g.
        // "aa", "a" => false
        // "aa", "aa" => true
        // "aaa", "aa" => false
        // "aa", "a*" => true
        // "aa", ".*" => true
        // "xy", ".*" => true
        // "aab", "c*a*b" => false
        // "aaaabc", "a*abc" => true

        System.out.print("Is Matching: " +  isMatching("aaaabc", "a*abc"));
    }

    public static boolean isMatching(String inStr, String inRegex) {
        if (inStr == null || inRegex == null) {
            return false;
        } else {
            return isMatching(inStr, inRegex, 0, 0);
        }
    }

    private static boolean isMatching(String text, String reg, int sIdx, int rIdx) {
        if (rIdx == reg.length()) {
            return (sIdx == text.length());
        }

        if (rIdx + 1 < reg.length() && reg.charAt(rIdx + 1) == '*') { // Check if second char is '*'
            return isMatching(text, reg, sIdx, rIdx + 2) ||            // If second char is '*' then jump to char after '*' in REGEX, meaning Zero character matching from regex because i is staying at same position
                    ((sIdx != text.length() && (text.charAt(sIdx) == reg.charAt(rIdx) || reg.charAt(rIdx) == '.'))
                    && isMatching(text, reg, sIdx + 1, rIdx));          // If second char is '*' and string-regex matches then jump to next char in String
        }

        if (sIdx != text.length() && (text.charAt(sIdx) == reg.charAt(rIdx) || reg.charAt(rIdx) == '.')) {
            return isMatching(text, reg, sIdx + 1, rIdx + 1);
        }

        return false;
    }
}
