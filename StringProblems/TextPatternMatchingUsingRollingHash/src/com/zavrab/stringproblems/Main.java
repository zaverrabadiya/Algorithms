package com.zavrab.stringproblems;

public class Main {

    public static void main(String[] args) {

        //
        // e.g.
        // "banana", "nan" => true
        // "banana", "cana" => false

        String text = "banana", pattern = "cana";

        System.out.print("Result: " + isTextPatternMatching(text, pattern));
    }

    public static boolean isTextPatternMatching(String inStr, String inPattern) {
        int patternLen = inPattern.length();

        if (inPattern.length() > inStr.length()) {
            return false;
        }

        int patternHash = calculateRollingHash(inPattern);
        int textHash = calculateRollingHash(inStr.substring(0, patternLen));

        if (textHash == patternHash && inStr.substring(0, inPattern.length()).equals(inPattern)) {
            return true;
        }

        int end = inStr.length() - patternLen;
        char left, right;

        for (int i = 1; i <= end; i++) {
            left = inStr.charAt(i - 1);
            right = inStr.charAt(i + patternLen - 1);
            textHash = updateRollingHash(textHash, left, right, patternLen);

            if (textHash == patternHash && inStr.substring(i, i + patternLen).equals(inPattern)) {
                return true;
            }
        }

        return false;
    }

    public static int calculateRollingHash(String str) {
        int hash = 0;

        // "daba" => 3 * 26^3 + 1 * 26^2 + 2 * 26^1 + 1 * 26^0

        for (int i = 0; i < str.length(); i++) {
            double power = (str.length() - 1) - i;
            int charInt = Character.toLowerCase(str.charAt(i)) - 'a' + 1;
            hash += charInt * Math.pow(26.0, power);
        }

        return hash % 31;
    }

    public static int updateRollingHash(int hash, char left, char right, int length) {

        // oldHash = "daba" => 3 * 26^3 + 1 * 26^2 + 2 * 26^1 + 1 * 26^0 = e.g. 2999

        // Update to "abac" add new character at end and remove one character from beginning
        // new Hash = "abac" => oldHash - (3 * 26^3), (oldHash * 26) + (2 * 26^0)
        double power = (length - 1);
        hash -= ((Character.toLowerCase(left) - 'a') + 1) * Math.pow(26, power);
        hash = (hash * 26) + ((Character.toLowerCase(right) - 'a') + 1);
        hash = hash % 31;
        return hash > 0 ? hash : hash + 31;
    }
}
