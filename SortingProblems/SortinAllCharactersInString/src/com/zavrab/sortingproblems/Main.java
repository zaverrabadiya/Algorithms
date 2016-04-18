package com.zavrab.sortingproblems;

public class Main {

    public static void main(String[] args) {
        //Sort all ASCII character in string using bucket sort
        //e.g.
        // Input = "This is easy"
        // Output = "  Taehiisssy"
        //
        // Input = "select * from UserTable ORDER BY name"
        // Output = "      *BDEORRTUYaabceeeeefllmmnorrsst"

        String input = "This is easy";
        String sortedString = sortCharacters(input);
        System.out.print(sortedString);
    }

    public static String sortCharacters(String inString) {
        String result = "";
        int[] buckets = new int[256];

        for (int i = 0; i < inString.length(); i++) {
            int ascii = inString.charAt(i);
            ++buckets[ascii];
        }

        result = getStringFromBuckets(buckets);
        return result;
    }

    private static String getStringFromBuckets(int[] buckets) {
        String result = "";

        for (int i = 0; i < buckets.length; i++) {
            result += listOfCharsToString(i, buckets[i]);
        }
        return result;
    }

    private static String listOfCharsToString(int ascii, int numberOfCharacters) {
        String str = "";
        char c = (char) ascii;
        for (int i = 0; i < numberOfCharacters; i++) {
            str += "" + c;
        }

        return str;
    }
}
