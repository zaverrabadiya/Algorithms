package com.zavrab.stringproblems;

public class Main {

    public static void main(String[] args) {
	// write your code here

        String text = "abracadabra";
        String pattern = "acad";

        System.out.print("Result: " + isTextPatternMatches(text, pattern));
    }

    public static boolean isTextPatternMatches(String text, String pattern) {
        boolean matchFound = false;
        char[] T = text.toCharArray();
        char [] P = pattern.toCharArray();
        int j = 0, m = pattern.length(), n = text.length();
        int[] overlap = kmpOverlapComputation(P);

        for (int i = 0; i < n; i++) {
            while (true) {
                if (T[i] == P[j]) {
                    j++;
                    if (j == m) {
                        matchFound = true;
                        j = overlap[j]; //Can break here and check the flag outside inner loop, if looking for first match only
                    }
                    break;
                } else if (j == 0) {
                    break;
                } else {
                    j = overlap[j];
                }
            }
        }
        return matchFound;
    }

    private static int[] kmpOverlapComputation(char[] pattern) {
        int[] overlap = new int[pattern.length + 1];
        int a;
        overlap[0] = -1; //Can not have overlap at 0, search function should jump to next character in text
        for (int i = 0; i < pattern.length; i++) {
            a = overlap[i] + 1;
            while (a > 0 && pattern[i] != pattern[a - 1])
                a = overlap[a - 1] + 1;

            overlap[i + 1] = a;
        }
        return overlap;
    }
}
