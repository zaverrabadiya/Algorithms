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
        // "aab", "c*a*b" => true
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

    private static boolean isMatching(String s, String r, int i, int j) {
        if (j == r.length()) {
            return (i == s.length());
        }

        if (j + 1 < r.length() && r.charAt(j + 1) == '*') { // Check if second char is '*'
            return isMatching(s, r, i, j + 2) ||            // If second char is '*' then jump to char after '*' in REGEX, meaning Zero character matching from regex because i is staying at same position
                    ((i != s.length() && (s.charAt(i) == r.charAt(j) || r.charAt(j) == '.'))
                    && isMatching(s, r, i + 1, j));          // If second char is '*' and string-regex matches then jump to next char in String
        }

        if (i != s.length() && (s.charAt(i) == r.charAt(j) || r.charAt(j) == '.')) {
            return isMatching(s, r, i + 1, j + 1);
        }
        return false;
    }
}
