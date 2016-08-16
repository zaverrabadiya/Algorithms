package com.zavrab.stringproblems;

public class Main {

    public static void main(String[] args) {
        // Generate all possible Numeronym.
        // Print progressively longer strings, until there is 2 in permutation
        // There is no point of going below 2, because it won't compress the string

        //e.g.
        // "batch" => "b3h", "ba2h", "b2ch"

        String input = "batch";

        printRle(input);
        //printRLEIteratively(input);
    }

    //RECURSIVE Solution
    public static void printRle(String str) {
        if (str  == null || str.length() < 4) {
            return;
        }

        printRle(str, 1, str.length()-1);
    }

    private static void printRle(String str, int s, int e) {
        if (s > (e - 2)) {
            return;
        }

        String result = str.substring(0, s) + (e-s) + str.substring(e);

        System.out.println(result);

        printRle(str, s + 1, e);
        printRle(str, s, e-1);
    }

    // ITERATIVE Solution
    public static void printRLEIteratively(String inStr) {
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
}
