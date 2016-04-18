package com.zavrab.sortingproblems;

import java.util.ArrayList;
import java.util.List;

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
        List<Character>[] buckets = getBuckets(inString);
        result = getStringFromBuckets(buckets);
        return result;
    }

    private static List<Character>[] getBuckets(String s) {
        List<Character>[] buckets = new List[256];
        List<Character> listOfChars;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int ascii = c;
            listOfChars = buckets[ascii] !=null? buckets[ascii] : new ArrayList<Character>();
            listOfChars.add(c);
            buckets[ascii] = listOfChars;
        }
        return buckets;
    }

    private static String getStringFromBuckets(List<Character>[] buckets) {
        String result = "";

        for (List<Character> characters : buckets) {
            result += listOfCharsToString(characters);
        }
        return result;
    }

    private static String listOfCharsToString(List<Character> listOfChars) {
        String str = "";

        if (listOfChars == null) {
            return str;
        }

        for (char c : listOfChars) {
            str += "" + c;
        }
        return str;
    }
}
