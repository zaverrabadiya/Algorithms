package com.zavrab.stringproblems;

public class Main {

    public static void main(String[] args) {
        // Generate all possible Numberonym.
        // Print progressively longer strings, until there is 2 in permutation
        // There is no point of going below 2, because it won't compress the string

        //e.g.
        // "batch" => "b3h", "ba2h", "b2ch"

	    printRLE("batch");
    }

    public static void printRLE(String inStr) {
        if (inStr.length() < 4) {
            return;
        }
        System.out.println(inStr + ":");

        int n = 1 << inStr.length();
        int start = 1 << inStr.length() - 1;

        for (int i = start + 1; i < n; i+=2) {
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
