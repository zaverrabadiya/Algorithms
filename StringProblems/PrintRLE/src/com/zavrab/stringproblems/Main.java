package com.zavrab.stringproblems;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        // Generate all possible Numeronym.
        // Print progressively longer strings, until there is 2 in permutation
        // There is no point of going below 2, because it won't compress the string

        //e.g.
        // "batch" => "b3h", "ba2h", "b2ch"

        String input = "batch";

//        printRle(input);
//        printRLEIteratively(input);
        generate();
    }

    //RECURSIVE Solution
    public static void printRle(String str) {
        if (str  == null || str.length() < 4) {
            return;
        }

        printRle(str, "" + str.charAt(0), 0, 1);
    }

    private static void printRle(String s, String pre, int count, int i) {
        String countStr = count > 1 ? "" + count : (count == 1) ? "" + s.charAt(i - 1) : "";

        String result = pre + countStr + s.charAt(i);

        if (i == s.length() - 1) {
            if (result.length() < s.length()) {
                System.out.println(result);
            }

            return;
        }

        printRle(s, pre, count + 1, i + 1);

        // Recurse with previous result and reset count to 0 to start new counter for rest of the string.
        printRle(s, result , 0, i + 1);
    }

    // ITERATIVE Solution
    private static void printRLEIteratively(String inStr) {
        if (inStr.length() < 4) {
            return;
        }

        System.out.println(inStr + ":");

        int n = 1 << inStr.length();  //e.g. len = 5 then n = 32
        int start = 1 << (inStr.length() - 1); //e.g. len = 5 then start = 16

        for (int i = start + 1; i < n; i+=2) { // +2 so it keeps first and last bit intact e.g. 10001= 17, 10011 = 19, 11001 = 21 and so on
            int count = 0;
            String result = "";

            for (int j = 0; j < inStr.length(); j++) {
                if ((i & (1 << j)) >= 1) {
                    String countStr = count > 1 ? "" + count : (count == 1)? "" + inStr.charAt(j - 1) : "";
                    result += countStr + inStr.charAt(j);
                    count = 0;
                } else {
                    ++count;
                }
            }

            if (result.length() < inStr.length()) {
                System.out.println(result);
            }
        }
    }

    private static Set<String> dictionary = new HashSet<String> (){{
        add("bats");
        add("beds");
        add("bees");
    }};

    private static void generate() {
        generate("b", 's', 0, 2);
    }

    private static void generate(String pre, char last, int i, int n) {
        if (i == n) {
            final String word = pre + last;
            if (dictionary.contains(word))
                System.out.println(word);
            return;
        }

        for (int j = 0; j < 26; j++) {
            generate(pre + ((char)(j + 'a')), last, i + 1, n);
        }
    }
}
